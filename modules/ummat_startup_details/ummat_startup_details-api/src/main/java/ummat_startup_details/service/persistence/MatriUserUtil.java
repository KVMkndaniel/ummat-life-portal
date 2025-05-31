/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ummat_startup_details.model.MatriUser;

/**
 * The persistence utility for the matri user service. This utility wraps <code>ummat_startup_details.service.persistence.impl.MatriUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserPersistence
 * @generated
 */
public class MatriUserUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MatriUser matriUser) {
		getPersistence().clearCache(matriUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MatriUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MatriUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MatriUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MatriUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MatriUser update(MatriUser matriUser) {
		return getPersistence().update(matriUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MatriUser update(
		MatriUser matriUser, ServiceContext serviceContext) {

		return getPersistence().update(matriUser, serviceContext);
	}

	/**
	 * Returns all the matri users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri users
	 */
	public static List<MatriUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the matri users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @return the range of matching matri users
	 */
	public static List<MatriUser> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the matri users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByUuid_First(
			String uuid, OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByUuid_First(
		String uuid, OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByUuid_Last(
			String uuid, OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByUuid_Last(
		String uuid, OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public static MatriUser[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the matri users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of matri users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching matri users
	 */
	public static List<MatriUser> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @return the range of matching matri users
	 */
	public static List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public static MatriUser[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the matri users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching matri users
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or throws a <code>NoSuchMatriUserException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByFind_matrimonyUsers(
			long userId, long companyId)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByFind_matrimonyUsers(userId, companyId);
	}

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByFind_matrimonyUsers(
		long userId, long companyId) {

		return getPersistence().fetchByFind_matrimonyUsers(userId, companyId);
	}

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByFind_matrimonyUsers(
		long userId, long companyId, boolean useFinderCache) {

		return getPersistence().fetchByFind_matrimonyUsers(
			userId, companyId, useFinderCache);
	}

	/**
	 * Removes the matri user where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matri user that was removed
	 */
	public static MatriUser removeByFind_matrimonyUsers(
			long userId, long companyId)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().removeByFind_matrimonyUsers(userId, companyId);
	}

	/**
	 * Returns the number of matri users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching matri users
	 */
	public static int countByFind_matrimonyUsers(long userId, long companyId) {
		return getPersistence().countByFind_matrimonyUsers(userId, companyId);
	}

	/**
	 * Returns all the matri users where area = &#63;.
	 *
	 * @param area the area
	 * @return the matching matri users
	 */
	public static List<MatriUser> findByfindByArea(String area) {
		return getPersistence().findByfindByArea(area);
	}

	/**
	 * Returns a range of all the matri users where area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param area the area
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @return the range of matching matri users
	 */
	public static List<MatriUser> findByfindByArea(
		String area, int start, int end) {

		return getPersistence().findByfindByArea(area, start, end);
	}

	/**
	 * Returns an ordered range of all the matri users where area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param area the area
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().findByfindByArea(
			area, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri users where area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param area the area
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByArea(
			area, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByfindByArea_First(
			String area, OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByArea_First(area, orderByComparator);
	}

	/**
	 * Returns the first matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByfindByArea_First(
		String area, OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByfindByArea_First(
			area, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByfindByArea_Last(
			String area, OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByArea_Last(area, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByfindByArea_Last(
		String area, OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByfindByArea_Last(area, orderByComparator);
	}

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where area = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public static MatriUser[] findByfindByArea_PrevAndNext(
			long id, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByArea_PrevAndNext(
			id, area, orderByComparator);
	}

	/**
	 * Removes all the matri users where area = &#63; from the database.
	 *
	 * @param area the area
	 */
	public static void removeByfindByArea(String area) {
		getPersistence().removeByfindByArea(area);
	}

	/**
	 * Returns the number of matri users where area = &#63;.
	 *
	 * @param area the area
	 * @return the number of matching matri users
	 */
	public static int countByfindByArea(String area) {
		return getPersistence().countByfindByArea(area);
	}

	/**
	 * Returns all the matri users where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @return the matching matri users
	 */
	public static List<MatriUser> findByfindByDistrict(String districtName) {
		return getPersistence().findByfindByDistrict(districtName);
	}

	/**
	 * Returns a range of all the matri users where districtName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param districtName the district name
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @return the range of matching matri users
	 */
	public static List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end) {

		return getPersistence().findByfindByDistrict(districtName, start, end);
	}

	/**
	 * Returns an ordered range of all the matri users where districtName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param districtName the district name
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().findByfindByDistrict(
			districtName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri users where districtName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param districtName the district name
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByDistrict(
			districtName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByfindByDistrict_First(
			String districtName, OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByDistrict_First(
			districtName, orderByComparator);
	}

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByfindByDistrict_First(
		String districtName, OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByfindByDistrict_First(
			districtName, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByfindByDistrict_Last(
			String districtName, OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByDistrict_Last(
			districtName, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByfindByDistrict_Last(
		String districtName, OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByfindByDistrict_Last(
			districtName, orderByComparator);
	}

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where districtName = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public static MatriUser[] findByfindByDistrict_PrevAndNext(
			long id, String districtName,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByDistrict_PrevAndNext(
			id, districtName, orderByComparator);
	}

	/**
	 * Removes all the matri users where districtName = &#63; from the database.
	 *
	 * @param districtName the district name
	 */
	public static void removeByfindByDistrict(String districtName) {
		getPersistence().removeByfindByDistrict(districtName);
	}

	/**
	 * Returns the number of matri users where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @return the number of matching matri users
	 */
	public static int countByfindByDistrict(String districtName) {
		return getPersistence().countByfindByDistrict(districtName);
	}

	/**
	 * Returns all the matri users where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @return the matching matri users
	 */
	public static List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area) {

		return getPersistence().findByfindByDistricAndAreat(districtName, area);
	}

	/**
	 * Returns a range of all the matri users where districtName = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @return the range of matching matri users
	 */
	public static List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end) {

		return getPersistence().findByfindByDistricAndAreat(
			districtName, area, start, end);
	}

	/**
	 * Returns an ordered range of all the matri users where districtName = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().findByfindByDistricAndAreat(
			districtName, area, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri users where districtName = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri users
	 */
	public static List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByDistricAndAreat(
			districtName, area, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByfindByDistricAndAreat_First(
			String districtName, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByDistricAndAreat_First(
			districtName, area, orderByComparator);
	}

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByfindByDistricAndAreat_First(
		String districtName, String area,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByfindByDistricAndAreat_First(
			districtName, area, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public static MatriUser findByfindByDistricAndAreat_Last(
			String districtName, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByDistricAndAreat_Last(
			districtName, area, orderByComparator);
	}

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public static MatriUser fetchByfindByDistricAndAreat_Last(
		String districtName, String area,
		OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().fetchByfindByDistricAndAreat_Last(
			districtName, area, orderByComparator);
	}

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public static MatriUser[] findByfindByDistricAndAreat_PrevAndNext(
			long id, String districtName, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByfindByDistricAndAreat_PrevAndNext(
			id, districtName, area, orderByComparator);
	}

	/**
	 * Removes all the matri users where districtName = &#63; and area = &#63; from the database.
	 *
	 * @param districtName the district name
	 * @param area the area
	 */
	public static void removeByfindByDistricAndAreat(
		String districtName, String area) {

		getPersistence().removeByfindByDistricAndAreat(districtName, area);
	}

	/**
	 * Returns the number of matri users where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @return the number of matching matri users
	 */
	public static int countByfindByDistricAndAreat(
		String districtName, String area) {

		return getPersistence().countByfindByDistricAndAreat(
			districtName, area);
	}

	/**
	 * Caches the matri user in the entity cache if it is enabled.
	 *
	 * @param matriUser the matri user
	 */
	public static void cacheResult(MatriUser matriUser) {
		getPersistence().cacheResult(matriUser);
	}

	/**
	 * Caches the matri users in the entity cache if it is enabled.
	 *
	 * @param matriUsers the matri users
	 */
	public static void cacheResult(List<MatriUser> matriUsers) {
		getPersistence().cacheResult(matriUsers);
	}

	/**
	 * Creates a new matri user with the primary key. Does not add the matri user to the database.
	 *
	 * @param id the primary key for the new matri user
	 * @return the new matri user
	 */
	public static MatriUser create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the matri user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user that was removed
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public static MatriUser remove(long id)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().remove(id);
	}

	public static MatriUser updateImpl(MatriUser matriUser) {
		return getPersistence().updateImpl(matriUser);
	}

	/**
	 * Returns the matri user with the primary key or throws a <code>NoSuchMatriUserException</code> if it could not be found.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public static MatriUser findByPrimaryKey(long id)
		throws ummat_startup_details.exception.NoSuchMatriUserException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the matri user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user, or <code>null</code> if a matri user with the primary key could not be found
	 */
	public static MatriUser fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the matri users.
	 *
	 * @return the matri users
	 */
	public static List<MatriUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the matri users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @return the range of matri users
	 */
	public static List<MatriUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the matri users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matri users
	 */
	public static List<MatriUser> findAll(
		int start, int end, OrderByComparator<MatriUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri users
	 * @param end the upper bound of the range of matri users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matri users
	 */
	public static List<MatriUser> findAll(
		int start, int end, OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the matri users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of matri users.
	 *
	 * @return the number of matri users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MatriUserPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(MatriUserPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile MatriUserPersistence _persistence;

}