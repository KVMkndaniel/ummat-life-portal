/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import ummat_startup_details.exception.NoSuchMatriUserException;

import ummat_startup_details.model.MatriUser;

/**
 * The persistence interface for the matri user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserUtil
 * @generated
 */
@ProviderType
public interface MatriUserPersistence extends BasePersistence<MatriUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MatriUserUtil} to access the matri user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the matri users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri users
	 */
	public java.util.List<MatriUser> findByUuid(String uuid);

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
	public java.util.List<MatriUser> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MatriUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public java.util.List<MatriUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public MatriUser[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Removes all the matri users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of matri users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri users
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching matri users
	 */
	public java.util.List<MatriUser> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public java.util.List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public MatriUser[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Removes all the matri users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching matri users
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or throws a <code>NoSuchMatriUserException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByFind_matrimonyUsers(long userId, long companyId)
		throws NoSuchMatriUserException;

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByFind_matrimonyUsers(long userId, long companyId);

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByFind_matrimonyUsers(
		long userId, long companyId, boolean useFinderCache);

	/**
	 * Removes the matri user where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matri user that was removed
	 */
	public MatriUser removeByFind_matrimonyUsers(long userId, long companyId)
		throws NoSuchMatriUserException;

	/**
	 * Returns the number of matri users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching matri users
	 */
	public int countByFind_matrimonyUsers(long userId, long companyId);

	/**
	 * Returns all the matri users where area = &#63;.
	 *
	 * @param area the area
	 * @return the matching matri users
	 */
	public java.util.List<MatriUser> findByfindByArea(String area);

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
	public java.util.List<MatriUser> findByfindByArea(
		String area, int start, int end);

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
	public java.util.List<MatriUser> findByfindByArea(
		String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public java.util.List<MatriUser> findByfindByArea(
		String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByfindByArea_First(
			String area,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the first matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByfindByArea_First(
		String area,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the last matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByfindByArea_Last(
			String area,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the last matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByfindByArea_Last(
		String area,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where area = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public MatriUser[] findByfindByArea_PrevAndNext(
			long id, String area,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Removes all the matri users where area = &#63; from the database.
	 *
	 * @param area the area
	 */
	public void removeByfindByArea(String area);

	/**
	 * Returns the number of matri users where area = &#63;.
	 *
	 * @param area the area
	 * @return the number of matching matri users
	 */
	public int countByfindByArea(String area);

	/**
	 * Returns all the matri users where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @return the matching matri users
	 */
	public java.util.List<MatriUser> findByfindByDistrict(String districtName);

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
	public java.util.List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end);

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
	public java.util.List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public java.util.List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByfindByDistrict_First(
			String districtName,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByfindByDistrict_First(
		String districtName,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByfindByDistrict_Last(
			String districtName,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByfindByDistrict_Last(
		String districtName,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the matri users before and after the current matri user in the ordered set where districtName = &#63;.
	 *
	 * @param id the primary key of the current matri user
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public MatriUser[] findByfindByDistrict_PrevAndNext(
			long id, String districtName,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Removes all the matri users where districtName = &#63; from the database.
	 *
	 * @param districtName the district name
	 */
	public void removeByfindByDistrict(String districtName);

	/**
	 * Returns the number of matri users where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @return the number of matching matri users
	 */
	public int countByfindByDistrict(String districtName);

	/**
	 * Returns all the matri users where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @return the matching matri users
	 */
	public java.util.List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area);

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
	public java.util.List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end);

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
	public java.util.List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public java.util.List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByfindByDistricAndAreat_First(
			String districtName, String area,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByfindByDistricAndAreat_First(
		String districtName, String area,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	public MatriUser findByfindByDistricAndAreat_Last(
			String districtName, String area,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	public MatriUser fetchByfindByDistricAndAreat_Last(
		String districtName, String area,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public MatriUser[] findByfindByDistricAndAreat_PrevAndNext(
			long id, String districtName, String area,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
				orderByComparator)
		throws NoSuchMatriUserException;

	/**
	 * Removes all the matri users where districtName = &#63; and area = &#63; from the database.
	 *
	 * @param districtName the district name
	 * @param area the area
	 */
	public void removeByfindByDistricAndAreat(String districtName, String area);

	/**
	 * Returns the number of matri users where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @return the number of matching matri users
	 */
	public int countByfindByDistricAndAreat(String districtName, String area);

	/**
	 * Caches the matri user in the entity cache if it is enabled.
	 *
	 * @param matriUser the matri user
	 */
	public void cacheResult(MatriUser matriUser);

	/**
	 * Caches the matri users in the entity cache if it is enabled.
	 *
	 * @param matriUsers the matri users
	 */
	public void cacheResult(java.util.List<MatriUser> matriUsers);

	/**
	 * Creates a new matri user with the primary key. Does not add the matri user to the database.
	 *
	 * @param id the primary key for the new matri user
	 * @return the new matri user
	 */
	public MatriUser create(long id);

	/**
	 * Removes the matri user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user that was removed
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public MatriUser remove(long id) throws NoSuchMatriUserException;

	public MatriUser updateImpl(MatriUser matriUser);

	/**
	 * Returns the matri user with the primary key or throws a <code>NoSuchMatriUserException</code> if it could not be found.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	public MatriUser findByPrimaryKey(long id) throws NoSuchMatriUserException;

	/**
	 * Returns the matri user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user, or <code>null</code> if a matri user with the primary key could not be found
	 */
	public MatriUser fetchByPrimaryKey(long id);

	/**
	 * Returns all the matri users.
	 *
	 * @return the matri users
	 */
	public java.util.List<MatriUser> findAll();

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
	public java.util.List<MatriUser> findAll(int start, int end);

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
	public java.util.List<MatriUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator);

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
	public java.util.List<MatriUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the matri users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of matri users.
	 *
	 * @return the number of matri users
	 */
	public int countAll();

}