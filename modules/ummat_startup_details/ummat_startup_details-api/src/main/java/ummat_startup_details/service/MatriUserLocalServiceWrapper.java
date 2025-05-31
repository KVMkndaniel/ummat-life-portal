/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link MatriUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserLocalService
 * @generated
 */
public class MatriUserLocalServiceWrapper
	implements MatriUserLocalService, ServiceWrapper<MatriUserLocalService> {

	public MatriUserLocalServiceWrapper() {
		this(null);
	}

	public MatriUserLocalServiceWrapper(
		MatriUserLocalService matriUserLocalService) {

		_matriUserLocalService = matriUserLocalService;
	}

	/**
	 * Adds the matri user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriUser the matri user
	 * @return the matri user that was added
	 */
	@Override
	public ummat_startup_details.model.MatriUser addMatriUser(
		ummat_startup_details.model.MatriUser matriUser) {

		return _matriUserLocalService.addMatriUser(matriUser);
	}

	/**
	 * Creates a new matri user with the primary key. Does not add the matri user to the database.
	 *
	 * @param id the primary key for the new matri user
	 * @return the new matri user
	 */
	@Override
	public ummat_startup_details.model.MatriUser createMatriUser(long id) {
		return _matriUserLocalService.createMatriUser(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the matri user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user that was removed
	 * @throws PortalException if a matri user with the primary key could not be found
	 */
	@Override
	public ummat_startup_details.model.MatriUser deleteMatriUser(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserLocalService.deleteMatriUser(id);
	}

	/**
	 * Deletes the matri user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriUser the matri user
	 * @return the matri user that was removed
	 */
	@Override
	public ummat_startup_details.model.MatriUser deleteMatriUser(
		ummat_startup_details.model.MatriUser matriUser) {

		return _matriUserLocalService.deleteMatriUser(matriUser);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _matriUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _matriUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _matriUserLocalService.dynamicQuery();
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

		return _matriUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat_startup_details.model.impl.MatriUserModelImpl</code>.
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

		return _matriUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat_startup_details.model.impl.MatriUserModelImpl</code>.
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

		return _matriUserLocalService.dynamicQuery(
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

		return _matriUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _matriUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ummat_startup_details.model.MatriUser fetchMatriUser(long id) {
		return _matriUserLocalService.fetchMatriUser(id);
	}

	/**
	 * Returns the matri user with the matching UUID and company.
	 *
	 * @param uuid the matri user's UUID
	 * @param companyId the primary key of the company
	 * @return the matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public ummat_startup_details.model.MatriUser
		fetchMatriUserByUuidAndCompanyId(String uuid, long companyId) {

		return _matriUserLocalService.fetchMatriUserByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _matriUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _matriUserLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _matriUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the matri user with the primary key.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user
	 * @throws PortalException if a matri user with the primary key could not be found
	 */
	@Override
	public ummat_startup_details.model.MatriUser getMatriUser(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserLocalService.getMatriUser(id);
	}

	/**
	 * Returns the matri user with the matching UUID and company.
	 *
	 * @param uuid the matri user's UUID
	 * @param companyId the primary key of the company
	 * @return the matching matri user
	 * @throws PortalException if a matching matri user could not be found
	 */
	@Override
	public ummat_startup_details.model.MatriUser getMatriUserByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserLocalService.getMatriUserByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the matri users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat_startup_details.model.impl.MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @return the range of matri users
	 */
	@Override
	public java.util.List<ummat_startup_details.model.MatriUser> getMatriUsers(
		int start, int end) {

		return _matriUserLocalService.getMatriUsers(start, end);
	}

	/**
	 * Returns the number of matri users.
	 *
	 * @return the number of matri users
	 */
	@Override
	public int getMatriUsersCount() {
		return _matriUserLocalService.getMatriUsersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matriUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the matri user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriUser the matri user
	 * @return the matri user that was updated
	 */
	@Override
	public ummat_startup_details.model.MatriUser updateMatriUser(
		ummat_startup_details.model.MatriUser matriUser) {

		return _matriUserLocalService.updateMatriUser(matriUser);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _matriUserLocalService.getBasePersistence();
	}

	@Override
	public MatriUserLocalService getWrappedService() {
		return _matriUserLocalService;
	}

	@Override
	public void setWrappedService(MatriUserLocalService matriUserLocalService) {
		_matriUserLocalService = matriUserLocalService;
	}

	private MatriUserLocalService _matriUserLocalService;

}