/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ummat.slayer.model.District;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for District. This utility wraps
 * <code>com.ummat.slayer.service.impl.DistrictLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictLocalService
 * @generated
 */
public class DistrictLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ummat.slayer.service.impl.DistrictLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the district to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param district the district
	 * @return the district that was added
	 */
	public static District addDistrict(District district) {
		return getService().addDistrict(district);
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public static District createDistrict(long districtId) {
		return getService().createDistrict(districtId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the district from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param district the district
	 * @return the district that was removed
	 */
	public static District deleteDistrict(District district) {
		return getService().deleteDistrict(district);
	}

	/**
	 * Deletes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws PortalException if a district with the primary key could not be found
	 */
	public static District deleteDistrict(long districtId)
		throws PortalException {

		return getService().deleteDistrict(districtId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static District fetchDistrict(long districtId) {
		return getService().fetchDistrict(districtId);
	}

	/**
	 * Returns the district with the matching UUID and company.
	 *
	 * @param uuid the district's UUID
	 * @param companyId the primary key of the company
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchDistrictByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchDistrictByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<District> getByRegionCode(String regionCode) {
		return getService().getByRegionCode(regionCode);
	}

	public static List<District> getByRegionId(long regionId) {
		return getService().getByRegionId(regionId);
	}

	/**
	 * Returns the district with the primary key.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws PortalException if a district with the primary key could not be found
	 */
	public static District getDistrict(long districtId) throws PortalException {
		return getService().getDistrict(districtId);
	}

	/**
	 * Returns the district with the matching UUID and company.
	 *
	 * @param uuid the district's UUID
	 * @param companyId the primary key of the company
	 * @return the matching district
	 * @throws PortalException if a matching district could not be found
	 */
	public static District getDistrictByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getDistrictByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 */
	public static List<District> getDistricts(int start, int end) {
		return getService().getDistricts(start, end);
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public static int getDistrictsCount() {
		return getService().getDistrictsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int getUserCountInUserGroup(long userGroupId)
		throws PortalException {

		return getService().getUserCountInUserGroup(userGroupId);
	}

	public static List<com.liferay.portal.kernel.model.UserGroup>
			getUserGroupsByDistrict(String districtName)
		throws PortalException {

		return getService().getUserGroupsByDistrict(districtName);
	}

	/**
	 * Updates the district in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param district the district
	 * @return the district that was updated
	 */
	public static District updateDistrict(District district) {
		return getService().updateDistrict(district);
	}

	public static DistrictLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DistrictLocalService> _serviceSnapshot =
		new Snapshot<>(
			DistrictLocalServiceUtil.class, DistrictLocalService.class);

}