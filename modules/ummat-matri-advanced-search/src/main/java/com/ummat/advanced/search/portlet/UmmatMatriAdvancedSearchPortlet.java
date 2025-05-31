package com.ummat.advanced.search.portlet;

import com.ummat.advanced.search.constants.UmmatMatriAdvancedSearchPortletKeys;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.DistrictLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import ummat_startup_details.model.MatriUser;
import ummat_startup_details.service.MatriUserLocalServiceUtil;

/**
 * @author Personal
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UmmatMatriAdvancedSearch",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UmmatMatriAdvancedSearchPortletKeys.UMMATMATRIADVANCEDSEARCH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UmmatMatriAdvancedSearchPortlet extends MVCPortlet {
	
	

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Set<User> currentProfileSet = new HashSet<>();
		currentProfileSet.addAll(UserLocalServiceUtil.getUsers(-1, -1));
		List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserUserGroups(themeDisplay.getUserId());
		for (UserGroup userGroupItem : userGroups) {
			List<User> users = UserLocalServiceUtil.getUserGroupUsers(userGroupItem.getUserGroupId());
			for (User userItem : users) {
				currentProfileSet.add(userItem);
				currentProfileSet.addAll(users);

			}
		}
		List<User> currentProfileList = new ArrayList<>(currentProfileSet);
		List<MatriUser> matriUserList = MatriUserLocalServiceUtil.getMatriUsers(-1, -1);
		List<District> districts = DistrictLocalServiceUtil.getDistricts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("districtLists", districts);
		renderRequest.setAttribute("currentProfiles", currentProfileList);
		renderRequest.setAttribute("matriUserList", matriUserList);
		Country country = null;
		try {
			country = CountryLocalServiceUtil.getCountryByA2(themeDisplay.getCompanyId(), 
					UmmatMatriAdvancedSearchPortletKeys.INDIA_COUNTRY_CODE);
			
		} catch (PortalException e) {

			e.printStackTrace();
			renderRequest.setAttribute("error", "Error fetching country: " + e.getMessage());
		}
		
		
		if (country != null) {
			
			try {
				List<Region>  regions = RegionLocalServiceUtil.getRegions(country.getCountryId(), true);
				renderRequest.setAttribute("regionLists", regions);
			} catch (PortalException e) {
				logger.error("Exception Occured "+e.getLocalizedMessage());
			}
			
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	        throws IOException, PortletException {
	    System.out.println("Inside serve resource------>>>");

	    try {
	        if ("Gnder".equalsIgnoreCase(resourceRequest.getResourceID())) {
	            String filterParam = ParamUtil.getString(resourceRequest, "genders", "");
	            System.out.println("Filters: " + filterParam);

	            filterParam = filterParam.replace("|", "| ");
	            String[] params = filterParam.split("\\|");
	            System.out.println("params: " + Arrays.toString(params));

	            // Extracting filter parameters
	            String gen = params[0].trim();
	            String[] genders = gen.isEmpty() ? new String[] { "all" } : gen.split(",");

	            String jamadh = params[1].trim();  // Jamath filter
	            String state = params[2].trim();   // State filter
	            String dist = params[3].trim();    // District filter
	            String area = params[4].trim();    // Area filter
	            String profile = params[5].trim(); // Profile filter
	            String languages = params[6].trim(); // language filter
	            String agefilter = params[7].trim(); // age filter
	            String professions = params[8].trim(); // profesion filter

	            Long distId = parseLong(dist);
	            Long profileId = parseLong(profile);

	            logger.info("jamadh: " + jamadh);
	            logger.info("state: " + state);
	            logger.info("dist: " + dist);
	            logger.info("area: " + area);
	            logger.info("profileId: " + profileId);
	            logger.info("languages: " + languages);
	            logger.info("agefilter: " + agefilter);
	            logger.info("professions: " + professions);

	            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
	            List<MatriUser> matriUsers = MatriUserLocalServiceUtil.getMatriUsers(-1, -1);

	            // Mapping MatriUsers by filters for quick lookup
	            Map<Long, MatriUser> userIdMap = matriUsers.stream()
	                    .collect(Collectors.toMap(MatriUser::getUserId, Function.identity()));

	            List<Long> excludedProfileIds = Arrays.asList(33847L, 33874L, 33880L, 40831L, 20099L, 20123L, 20127L, 112583L, 112610L, 112616L);

	            // Filtering Users
	            List<User> filteredUsers = users.stream()
	                    .filter(user -> !excludedProfileIds.contains(user.getUserId()))
	                    .filter(user -> {
							try {
								return passesGenderFilter(user, genders);
							} catch (PortalException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return clearRequestParameters;
						})
	                    .filter(user -> passesJamathFilter(user, jamadh, userIdMap))
	                    .filter(user -> passesStateFilter(user, state, userIdMap))
	                    .filter(user -> passesDistrictFilter(user, distId, userIdMap))
	                    .filter(user -> passesAreaFilter(user, area, userIdMap))
	                    .filter(user -> passeslanguagesFilter(user, languages, userIdMap))
	                    .filter(user -> passesAgeFilter(user, agefilter, userIdMap))
	                    .filter(user -> passesprofessionsFilter(user, professions, userIdMap))
	                   
	                    .collect(Collectors.toList());

	            // Preparing JSON Response
	            JSONArray usersArray = JSONFactoryUtil.createJSONArray();
	            ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

	            for (User user : filteredUsers) {
	                JSONObject userJson = JSONFactoryUtil.createJSONObject();
	                userJson.put("userId", user.getUserId());
	                userJson.put("portraitURL", user.getPortraitURL(themeDisplay));
	                userJson.put("fullName", user.getFullName());
	                userJson.put("jobTitle", user.getJobTitle());
	                userJson.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(user.getCreateDate()));

	                MatriUser matriUser = userIdMap.get(user.getUserId());
	                if (matriUser != null) {
	                    userJson.put("Jamath", matriUser.getJamath());
	                }

	                PortletURL informationRenderURL = PortletURLFactoryUtil.create(
	                        resourceRequest,
	                        themeDisplay.getPpid(),
	                        themeDisplay.getPlid(),
	                        PortletRequest.RENDER_PHASE
	                );
	                informationRenderURL.setParameter("jspPage", "/Matri/ProfileDetails.jsp");
	                informationRenderURL.setParameter("userId", String.valueOf(user.getUserId()));

	                userJson.put("informationRenderURL", informationRenderURL.toString());
	                usersArray.put(userJson);
	            }

	            JSONObject responseObject = JSONFactoryUtil.createJSONObject();
	            responseObject.put("currentProfiles", usersArray);

	            PrintWriter out = resourceResponse.getWriter();
	            out.print(responseObject.toString());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// Utility Methods
	private Long parseLong(String value) {
	    try {
	        return value.isEmpty() ? 0L : Long.parseLong(value);
	    } catch (NumberFormatException e) {
	        return 0L;
	    }
	}

	private boolean passesGenderFilter(User user, String[] genders) throws PortalException {
	    if (Arrays.asList(genders).contains("all")) return true;
	    String userGender = user.isMale() ? "male" : "female";
	    return Arrays.asList(genders).contains(userGender);
	}

	private boolean passesJamathFilter(User user, String jamadh, Map<Long, MatriUser> userIdMap) {
	    if (jamadh == null || jamadh.isEmpty()) return true;
	    MatriUser matriUser = userIdMap.get(user.getUserId());
	    return matriUser != null && jamadh.equals(matriUser.getJamath());
	}
	
	private boolean passeslanguagesFilter(User user, String languages, Map<Long, MatriUser> userIdMap) {
	    if (languages == null || languages.isEmpty()) return true;
	    MatriUser matriUser = userIdMap.get(user.getUserId());
	    return matriUser != null && languages.equals(matriUser.getMothertongueLanguage());
	}
	
	private boolean passesprofessionsFilter(User user, String professions, Map<Long, MatriUser> userIdMap) {
	    if (professions == null || professions.isEmpty()) return true;
	    MatriUser matriUser = userIdMap.get(user.getUserId());
	    return matriUser != null && professions.equals(user.getJobTitle());
	}
	
	private boolean passesAgeFilter(User user, String ageFilter, Map<Long, MatriUser> userIdMap) {
	    if (ageFilter == null || ageFilter.isEmpty()) return true;

	    MatriUser matriUser = userIdMap.get(user.getUserId());
	    try {
			if (matriUser == null || user.getBirthday() == null) return false;
	    LocalDate dob = user.getBirthday().toInstant()
	        .atZone(ZoneId.systemDefault())
	        .toLocalDate();

	    int age = Period.between(dob, LocalDate.now()).getYears();
	    switch (ageFilter) {
	        case "18to21":
	            return age >= 18 && age <= 21;
	        case "21to25":
	            return age >= 21 && age <= 25;
	        case "25to28":
	            return age >= 25 && age <= 28;
	        case "29to32":
	            return age >= 29 && age <= 32;
	        case "32toAbove":
	            return age >= 32;
	        default:
	           
	    }
	    } catch (PortalException e) {
			e.printStackTrace();
		}
	    return true;
	}


	private boolean passesStateFilter(User user, String state, Map<Long, MatriUser> userIdMap) {
	    if (state == null || state.isEmpty()) return true;
	    MatriUser matriUser = userIdMap.get(user.getUserId());
	    return matriUser != null && state.equals(matriUser.getStateName());
	}

	private boolean passesDistrictFilter(User user, Long distId, Map<Long, MatriUser> userIdMap) {
	    if (distId == 0) return true;
	    MatriUser matriUser = userIdMap.get(user.getUserId());
	    return matriUser != null && distId.equals(matriUser.getDistrictid());
	}

	private boolean passesAreaFilter(User user, String area, Map<Long, MatriUser> userIdMap) {
	    if (area == null || area.isEmpty()) return true;
	    MatriUser matriUser = userIdMap.get(user.getUserId());
	    return matriUser != null && area.equals(matriUser.getArea());
	}


	private static final Log logger = LogFactoryUtil.getLog(UmmatMatriAdvancedSearchPortlet.class);

}