/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link MatriImagesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatriImagesLocalService
 * @generated
 */
public class MatriImagesLocalServiceWrapper
	implements MatriImagesLocalService,
			   ServiceWrapper<MatriImagesLocalService> {

	public MatriImagesLocalServiceWrapper() {
		this(null);
	}

	public MatriImagesLocalServiceWrapper(
		MatriImagesLocalService matriImagesLocalService) {

		_matriImagesLocalService = matriImagesLocalService;
	}

	@Override
	public void addMatriImages(
		long groupId, long companyId, long userId, String userName,
		long dlEntryId) {

		_matriImagesLocalService.addMatriImages(
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
	@Override
	public com.ummat.slayer.model.MatriImages addMatriImages(
		com.ummat.slayer.model.MatriImages matriImages) {

		return _matriImagesLocalService.addMatriImages(matriImages);
	}

	/**
	 * Creates a new matri images with the primary key. Does not add the matri images to the database.
	 *
	 * @param id the primary key for the new matri images
	 * @return the new matri images
	 */
	@Override
	public com.ummat.slayer.model.MatriImages createMatriImages(long id) {
		return _matriImagesLocalService.createMatriImages(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriImagesLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ummat.slayer.model.MatriImages deleteMatriImages(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriImagesLocalService.deleteMatriImages(id);
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
	@Override
	public com.ummat.slayer.model.MatriImages deleteMatriImages(
		com.ummat.slayer.model.MatriImages matriImages) {

		return _matriImagesLocalService.deleteMatriImages(matriImages);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriImagesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _matriImagesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _matriImagesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _matriImagesLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _matriImagesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _matriImagesLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _matriImagesLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _matriImagesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _matriImagesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ummat.slayer.model.MatriImages fetchMatriImages(long id) {
		return _matriImagesLocalService.fetchMatriImages(id);
	}

	/**
	 * Returns the matri images matching the UUID and group.
	 *
	 * @param uuid the matri images's UUID
	 * @param groupId the primary key of the group
	 * @return the matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	@Override
	public com.ummat.slayer.model.MatriImages fetchMatriImagesByUuidAndGroupId(
		String uuid, long groupId) {

		return _matriImagesLocalService.fetchMatriImagesByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _matriImagesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _matriImagesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public java.util.List<com.ummat.slayer.model.MatriImages> getImagesByUserId(
		long userId) {

		return _matriImagesLocalService.getImagesByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _matriImagesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the matri images with the primary key.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images
	 * @throws PortalException if a matri images with the primary key could not be found
	 */
	@Override
	public com.ummat.slayer.model.MatriImages getMatriImages(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriImagesLocalService.getMatriImages(id);
	}

	/**
	 * Returns the matri images matching the UUID and group.
	 *
	 * @param uuid the matri images's UUID
	 * @param groupId the primary key of the group
	 * @return the matching matri images
	 * @throws PortalException if a matching matri images could not be found
	 */
	@Override
	public com.ummat.slayer.model.MatriImages getMatriImagesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriImagesLocalService.getMatriImagesByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.ummat.slayer.model.MatriImages> getMatriImageses(
		int start, int end) {

		return _matriImagesLocalService.getMatriImageses(start, end);
	}

	/**
	 * Returns all the matri imageses matching the UUID and company.
	 *
	 * @param uuid the UUID of the matri imageses
	 * @param companyId the primary key of the company
	 * @return the matching matri imageses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ummat.slayer.model.MatriImages>
		getMatriImagesesByUuidAndCompanyId(String uuid, long companyId) {

		return _matriImagesLocalService.getMatriImagesesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.ummat.slayer.model.MatriImages>
		getMatriImagesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ummat.slayer.model.MatriImages> orderByComparator) {

		return _matriImagesLocalService.getMatriImagesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of matri imageses.
	 *
	 * @return the number of matri imageses
	 */
	@Override
	public int getMatriImagesesCount() {
		return _matriImagesLocalService.getMatriImagesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matriImagesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriImagesLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ummat.slayer.model.MatriImages updateMatriImages(
		com.ummat.slayer.model.MatriImages matriImages) {

		return _matriImagesLocalService.updateMatriImages(matriImages);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _matriImagesLocalService.getBasePersistence();
	}

	@Override
	public MatriImagesLocalService getWrappedService() {
		return _matriImagesLocalService;
	}

	@Override
	public void setWrappedService(
		MatriImagesLocalService matriImagesLocalService) {

		_matriImagesLocalService = matriImagesLocalService;
	}

	private MatriImagesLocalService _matriImagesLocalService;

}