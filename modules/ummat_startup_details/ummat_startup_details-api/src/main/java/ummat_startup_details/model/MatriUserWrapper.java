/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MatriUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriUser
 * @generated
 */
public class MatriUserWrapper
	extends BaseModelWrapper<MatriUser>
	implements MatriUser, ModelWrapper<MatriUser> {

	public MatriUserWrapper(MatriUser matriUser) {
		super(matriUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("education", getEducation());
		attributes.put("countryid", getCountryid());
		attributes.put("countryName", getCountryName());
		attributes.put("stateid", getStateid());
		attributes.put("stateName", getStateName());
		attributes.put("districtid", getDistrictid());
		attributes.put("districtName", getDistrictName());
		attributes.put("area", getArea());
		attributes.put("jamath", getJamath());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("height", getHeight());
		attributes.put("weight", getWeight());
		attributes.put("ConvertMuslim", getConvertMuslim());
		attributes.put("primaryId", getPrimaryId());
		attributes.put("imageId", getImageId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("color", getColor());
		attributes.put("bio", getBio());
		attributes.put("malechild", getMalechild());
		attributes.put("femalechild", getFemalechild());
		attributes.put("MothertongueLanguage", getMothertongueLanguage());
		attributes.put("LivingPlace", getLivingPlace());
		attributes.put("Monthlyincome", getMonthlyincome());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String education = (String)attributes.get("education");

		if (education != null) {
			setEducation(education);
		}

		Long countryid = (Long)attributes.get("countryid");

		if (countryid != null) {
			setCountryid(countryid);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		Long stateid = (Long)attributes.get("stateid");

		if (stateid != null) {
			setStateid(stateid);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		Long districtid = (Long)attributes.get("districtid");

		if (districtid != null) {
			setDistrictid(districtid);
		}

		String districtName = (String)attributes.get("districtName");

		if (districtName != null) {
			setDistrictName(districtName);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		String jamath = (String)attributes.get("jamath");

		if (jamath != null) {
			setJamath(jamath);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Double height = (Double)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String ConvertMuslim = (String)attributes.get("ConvertMuslim");

		if (ConvertMuslim != null) {
			setConvertMuslim(ConvertMuslim);
		}

		String primaryId = (String)attributes.get("primaryId");

		if (primaryId != null) {
			setPrimaryId(primaryId);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		String bio = (String)attributes.get("bio");

		if (bio != null) {
			setBio(bio);
		}

		String malechild = (String)attributes.get("malechild");

		if (malechild != null) {
			setMalechild(malechild);
		}

		String femalechild = (String)attributes.get("femalechild");

		if (femalechild != null) {
			setFemalechild(femalechild);
		}

		String MothertongueLanguage = (String)attributes.get(
			"MothertongueLanguage");

		if (MothertongueLanguage != null) {
			setMothertongueLanguage(MothertongueLanguage);
		}

		String LivingPlace = (String)attributes.get("LivingPlace");

		if (LivingPlace != null) {
			setLivingPlace(LivingPlace);
		}

		Double Monthlyincome = (Double)attributes.get("Monthlyincome");

		if (Monthlyincome != null) {
			setMonthlyincome(Monthlyincome);
		}
	}

	@Override
	public MatriUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area of this matri user.
	 *
	 * @return the area of this matri user
	 */
	@Override
	public String getArea() {
		return model.getArea();
	}

	/**
	 * Returns the bio of this matri user.
	 *
	 * @return the bio of this matri user
	 */
	@Override
	public String getBio() {
		return model.getBio();
	}

	/**
	 * Returns the color of this matri user.
	 *
	 * @return the color of this matri user
	 */
	@Override
	public String getColor() {
		return model.getColor();
	}

	/**
	 * Returns the company ID of this matri user.
	 *
	 * @return the company ID of this matri user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the convert muslim of this matri user.
	 *
	 * @return the convert muslim of this matri user
	 */
	@Override
	public String getConvertMuslim() {
		return model.getConvertMuslim();
	}

	/**
	 * Returns the countryid of this matri user.
	 *
	 * @return the countryid of this matri user
	 */
	@Override
	public long getCountryid() {
		return model.getCountryid();
	}

	/**
	 * Returns the country name of this matri user.
	 *
	 * @return the country name of this matri user
	 */
	@Override
	public String getCountryName() {
		return model.getCountryName();
	}

	/**
	 * Returns the create date of this matri user.
	 *
	 * @return the create date of this matri user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the districtid of this matri user.
	 *
	 * @return the districtid of this matri user
	 */
	@Override
	public long getDistrictid() {
		return model.getDistrictid();
	}

	/**
	 * Returns the district name of this matri user.
	 *
	 * @return the district name of this matri user
	 */
	@Override
	public String getDistrictName() {
		return model.getDistrictName();
	}

	/**
	 * Returns the education of this matri user.
	 *
	 * @return the education of this matri user
	 */
	@Override
	public String getEducation() {
		return model.getEducation();
	}

	/**
	 * Returns the femalechild of this matri user.
	 *
	 * @return the femalechild of this matri user
	 */
	@Override
	public String getFemalechild() {
		return model.getFemalechild();
	}

	/**
	 * Returns the height of this matri user.
	 *
	 * @return the height of this matri user
	 */
	@Override
	public Double getHeight() {
		return model.getHeight();
	}

	/**
	 * Returns the ID of this matri user.
	 *
	 * @return the ID of this matri user
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image ID of this matri user.
	 *
	 * @return the image ID of this matri user
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the jamath of this matri user.
	 *
	 * @return the jamath of this matri user
	 */
	@Override
	public String getJamath() {
		return model.getJamath();
	}

	/**
	 * Returns the living place of this matri user.
	 *
	 * @return the living place of this matri user
	 */
	@Override
	public String getLivingPlace() {
		return model.getLivingPlace();
	}

	/**
	 * Returns the malechild of this matri user.
	 *
	 * @return the malechild of this matri user
	 */
	@Override
	public String getMalechild() {
		return model.getMalechild();
	}

	/**
	 * Returns the marital status of this matri user.
	 *
	 * @return the marital status of this matri user
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the modified date of this matri user.
	 *
	 * @return the modified date of this matri user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monthlyincome of this matri user.
	 *
	 * @return the monthlyincome of this matri user
	 */
	@Override
	public double getMonthlyincome() {
		return model.getMonthlyincome();
	}

	/**
	 * Returns the mothertongue language of this matri user.
	 *
	 * @return the mothertongue language of this matri user
	 */
	@Override
	public String getMothertongueLanguage() {
		return model.getMothertongueLanguage();
	}

	/**
	 * Returns the primary ID of this matri user.
	 *
	 * @return the primary ID of this matri user
	 */
	@Override
	public String getPrimaryId() {
		return model.getPrimaryId();
	}

	/**
	 * Returns the primary key of this matri user.
	 *
	 * @return the primary key of this matri user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stateid of this matri user.
	 *
	 * @return the stateid of this matri user
	 */
	@Override
	public long getStateid() {
		return model.getStateid();
	}

	/**
	 * Returns the state name of this matri user.
	 *
	 * @return the state name of this matri user
	 */
	@Override
	public String getStateName() {
		return model.getStateName();
	}

	/**
	 * Returns the user ID of this matri user.
	 *
	 * @return the user ID of this matri user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this matri user.
	 *
	 * @return the user uuid of this matri user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this matri user.
	 *
	 * @return the uuid of this matri user
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the weight of this matri user.
	 *
	 * @return the weight of this matri user
	 */
	@Override
	public double getWeight() {
		return model.getWeight();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the area of this matri user.
	 *
	 * @param area the area of this matri user
	 */
	@Override
	public void setArea(String area) {
		model.setArea(area);
	}

	/**
	 * Sets the bio of this matri user.
	 *
	 * @param bio the bio of this matri user
	 */
	@Override
	public void setBio(String bio) {
		model.setBio(bio);
	}

	/**
	 * Sets the color of this matri user.
	 *
	 * @param color the color of this matri user
	 */
	@Override
	public void setColor(String color) {
		model.setColor(color);
	}

	/**
	 * Sets the company ID of this matri user.
	 *
	 * @param companyId the company ID of this matri user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the convert muslim of this matri user.
	 *
	 * @param ConvertMuslim the convert muslim of this matri user
	 */
	@Override
	public void setConvertMuslim(String ConvertMuslim) {
		model.setConvertMuslim(ConvertMuslim);
	}

	/**
	 * Sets the countryid of this matri user.
	 *
	 * @param countryid the countryid of this matri user
	 */
	@Override
	public void setCountryid(long countryid) {
		model.setCountryid(countryid);
	}

	/**
	 * Sets the country name of this matri user.
	 *
	 * @param countryName the country name of this matri user
	 */
	@Override
	public void setCountryName(String countryName) {
		model.setCountryName(countryName);
	}

	/**
	 * Sets the create date of this matri user.
	 *
	 * @param createDate the create date of this matri user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the districtid of this matri user.
	 *
	 * @param districtid the districtid of this matri user
	 */
	@Override
	public void setDistrictid(long districtid) {
		model.setDistrictid(districtid);
	}

	/**
	 * Sets the district name of this matri user.
	 *
	 * @param districtName the district name of this matri user
	 */
	@Override
	public void setDistrictName(String districtName) {
		model.setDistrictName(districtName);
	}

	/**
	 * Sets the education of this matri user.
	 *
	 * @param education the education of this matri user
	 */
	@Override
	public void setEducation(String education) {
		model.setEducation(education);
	}

	/**
	 * Sets the femalechild of this matri user.
	 *
	 * @param femalechild the femalechild of this matri user
	 */
	@Override
	public void setFemalechild(String femalechild) {
		model.setFemalechild(femalechild);
	}

	/**
	 * Sets the height of this matri user.
	 *
	 * @param height the height of this matri user
	 */
	@Override
	public void setHeight(Double height) {
		model.setHeight(height);
	}

	/**
	 * Sets the ID of this matri user.
	 *
	 * @param id the ID of this matri user
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image ID of this matri user.
	 *
	 * @param imageId the image ID of this matri user
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the jamath of this matri user.
	 *
	 * @param jamath the jamath of this matri user
	 */
	@Override
	public void setJamath(String jamath) {
		model.setJamath(jamath);
	}

	/**
	 * Sets the living place of this matri user.
	 *
	 * @param LivingPlace the living place of this matri user
	 */
	@Override
	public void setLivingPlace(String LivingPlace) {
		model.setLivingPlace(LivingPlace);
	}

	/**
	 * Sets the malechild of this matri user.
	 *
	 * @param malechild the malechild of this matri user
	 */
	@Override
	public void setMalechild(String malechild) {
		model.setMalechild(malechild);
	}

	/**
	 * Sets the marital status of this matri user.
	 *
	 * @param maritalStatus the marital status of this matri user
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the modified date of this matri user.
	 *
	 * @param modifiedDate the modified date of this matri user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the monthlyincome of this matri user.
	 *
	 * @param Monthlyincome the monthlyincome of this matri user
	 */
	@Override
	public void setMonthlyincome(double Monthlyincome) {
		model.setMonthlyincome(Monthlyincome);
	}

	/**
	 * Sets the mothertongue language of this matri user.
	 *
	 * @param MothertongueLanguage the mothertongue language of this matri user
	 */
	@Override
	public void setMothertongueLanguage(String MothertongueLanguage) {
		model.setMothertongueLanguage(MothertongueLanguage);
	}

	/**
	 * Sets the primary ID of this matri user.
	 *
	 * @param primaryId the primary ID of this matri user
	 */
	@Override
	public void setPrimaryId(String primaryId) {
		model.setPrimaryId(primaryId);
	}

	/**
	 * Sets the primary key of this matri user.
	 *
	 * @param primaryKey the primary key of this matri user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stateid of this matri user.
	 *
	 * @param stateid the stateid of this matri user
	 */
	@Override
	public void setStateid(long stateid) {
		model.setStateid(stateid);
	}

	/**
	 * Sets the state name of this matri user.
	 *
	 * @param stateName the state name of this matri user
	 */
	@Override
	public void setStateName(String stateName) {
		model.setStateName(stateName);
	}

	/**
	 * Sets the user ID of this matri user.
	 *
	 * @param userId the user ID of this matri user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this matri user.
	 *
	 * @param userUuid the user uuid of this matri user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this matri user.
	 *
	 * @param uuid the uuid of this matri user
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the weight of this matri user.
	 *
	 * @param weight the weight of this matri user
	 */
	@Override
	public void setWeight(double weight) {
		model.setWeight(weight);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected MatriUserWrapper wrap(MatriUser matriUser) {
		return new MatriUserWrapper(matriUser);
	}

}