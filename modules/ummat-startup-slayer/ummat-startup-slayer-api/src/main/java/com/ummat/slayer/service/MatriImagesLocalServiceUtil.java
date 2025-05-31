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

import com.ummat.slayer.model.MatriImages;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MatriImages. This utility wraps
 * <code>com.ummat.slayer.service.impl.MatriImagesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MatriImagesLocalService
 * @generated
 */
public class MatriImagesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ummat.slayer.service.impl.MatriImagesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addMatriImages(
		long groupId, long companyId, long userId, String userName,
		long dlEntryId) {

		getService().addMatriImages(
			groupId, companyId, userId, userName, dlEntryId);
	}

	/**
	 * Adds the matri images to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriImagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriImages the matri images
	 * @return the matri images that was added
	 */
	public static MatriImages addMatriImages(MatriImages matriImages) {
		return getService().addMatriImages(matriImages);
	}

	/**
	 * Creates a new matri images with the primary key. Does not add the matri images to the database.
	 *
	 * @param id the primary key for the new matri images
	 * @return the new matri images
	 */
	public static MatriImages createMatriImages(long id) {
		return getService().createMatriImages(id);
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
	 * Deletes the matri images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriImagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images that was removed
	 * @throws PortalException if a matri images with the primary key could not be found
	 */
	public static MatriImages deleteMatriImages(long id)
		throws PortalException {

		return getService().deleteMatriImages(id);
	}

	/**
	 * Deletes the matri images from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriImagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriImages the matri images
	 * @return the matri images that was removed
	 */
	public static MatriImages deleteMatriImages(MatriImages matriImages) {
		return getService().deleteMatriImages(matriImages);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.MatriImagesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.MatriImagesModelImpl</code>.
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

	public static MatriImages fetchMatriImages(long id) {
		return getService().fetchMatriImages(id);
	}

	/**
	 * Returns the matri images matching the UUID and group.
	 *
	 * @param uuid the matri images's UUID
	 * @param groupId the primary key of the group
	 * @return the matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchMatriImagesByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchMatriImagesByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static List<MatriImages> getImagesByUserId(long userId) {
		return getService().getImagesByUserId(userId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the matri images with the primary key.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images
	 * @throws PortalException if a matri images with the primary key could not be found
	 */
	public static MatriImages getMatriImages(long id) throws PortalException {
		return getService().getMatriImages(id);
	}

	/**
	 * Returns the matri images matching the UUID and group.
	 *
	 * @param uuid the matri images's UUID
	 * @param groupId the primary key of the group
	 * @return the matching matri images
	 * @throws PortalException if a matching matri images could not be found
	 */
	public static MatriImages getMatriImagesByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getMatriImagesByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the matri imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @return the range of matri imageses
	 */
	public static List<MatriImages> getMatriImageses(int start, int end) {
		return getService().getMatriImageses(start, end);
	}

	/**
	 * Returns all the matri imageses matching the UUID and company.
	 *
	 * @param uuid the UUID of the matri imageses
	 * @param companyId the primary key of the company
	 * @return the matching matri imageses, or an empty list if no matches were found
	 */
	public static List<MatriImages> getMatriImagesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getMatriImagesesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of matri imageses matching the UUID and company.
	 *
	 * @param uuid the UUID of the matri imageses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching matri imageses, or an empty list if no matches were found
	 */
	public static List<MatriImages> getMatriImagesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MatriImages> orderByComparator) {

		return getService().getMatriImagesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of matri imageses.
	 *
	 * @return the number of matri imageses
	 */
	public static int getMatriImagesesCount() {
		return getService().getMatriImagesesCount();
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

	/**
	 * Updates the matri images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriImagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriImages the matri images
	 * @return the matri images that was updated
	 */
	public static MatriImages updateMatriImages(MatriImages matriImages) {
		return getService().updateMatriImages(matriImages);
	}

	public static MatriImagesLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<MatriImagesLocalService> _serviceSnapshot =
		new Snapshot<>(
			MatriImagesLocalServiceUtil.class, MatriImagesLocalService.class);

}