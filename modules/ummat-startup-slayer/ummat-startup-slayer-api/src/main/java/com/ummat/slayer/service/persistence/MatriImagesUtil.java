/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ummat.slayer.model.MatriImages;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the matri images service. This utility wraps <code>com.ummat.slayer.service.persistence.impl.MatriImagesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriImagesPersistence
 * @generated
 */
public class MatriImagesUtil {

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
	public static void clearCache(MatriImages matriImages) {
		getPersistence().clearCache(matriImages);
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
	public static Map<Serializable, MatriImages> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MatriImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MatriImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MatriImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MatriImages update(MatriImages matriImages) {
		return getPersistence().update(matriImages);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MatriImages update(
		MatriImages matriImages, ServiceContext serviceContext) {

		return getPersistence().update(matriImages, serviceContext);
	}

	/**
	 * Returns all the matri imageses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri imageses
	 */
	public static List<MatriImages> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the matri imageses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @return the range of matching matri imageses
	 */
	public static List<MatriImages> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the matri imageses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri imageses
	 */
	public static List<MatriImages> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri imageses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri imageses
	 */
	public static List<MatriImages> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriImages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public static MatriImages findByUuid_First(
			String uuid, OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByUuid_First(
		String uuid, OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public static MatriImages findByUuid_Last(
			String uuid, OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByUuid_Last(
		String uuid, OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the matri imageses before and after the current matri images in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current matri images
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri images
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public static MatriImages[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the matri imageses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of matri imageses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri imageses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the matri images where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMatriImagesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public static MatriImages findByUUID_G(String uuid, long groupId)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the matri images where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the matri images where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the matri images where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matri images that was removed
	 */
	public static MatriImages removeByUUID_G(String uuid, long groupId)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of matri imageses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching matri imageses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the matri imageses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching matri imageses
	 */
	public static List<MatriImages> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the matri imageses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @return the range of matching matri imageses
	 */
	public static List<MatriImages> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the matri imageses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri imageses
	 */
	public static List<MatriImages> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri imageses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri imageses
	 */
	public static List<MatriImages> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MatriImages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public static MatriImages findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public static MatriImages findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the matri imageses before and after the current matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current matri images
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri images
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public static MatriImages[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the matri imageses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of matri imageses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching matri imageses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the matri imageses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching matri imageses
	 */
	public static List<MatriImages> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the matri imageses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @return the range of matching matri imageses
	 */
	public static List<MatriImages> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the matri imageses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri imageses
	 */
	public static List<MatriImages> findByuserId(
		long userId, int start, int end,
		OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri imageses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri imageses
	 */
	public static List<MatriImages> findByuserId(
		long userId, int start, int end,
		OrderByComparator<MatriImages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public static MatriImages findByuserId_First(
			long userId, OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByuserId_First(
		long userId, OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public static MatriImages findByuserId_Last(
			long userId, OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public static MatriImages fetchByuserId_Last(
		long userId, OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the matri imageses before and after the current matri images in the ordered set where userId = &#63;.
	 *
	 * @param id the primary key of the current matri images
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri images
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public static MatriImages[] findByuserId_PrevAndNext(
			long id, long userId,
			OrderByComparator<MatriImages> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByuserId_PrevAndNext(
			id, userId, orderByComparator);
	}

	/**
	 * Removes all the matri imageses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of matri imageses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching matri imageses
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the matri images in the entity cache if it is enabled.
	 *
	 * @param matriImages the matri images
	 */
	public static void cacheResult(MatriImages matriImages) {
		getPersistence().cacheResult(matriImages);
	}

	/**
	 * Caches the matri imageses in the entity cache if it is enabled.
	 *
	 * @param matriImageses the matri imageses
	 */
	public static void cacheResult(List<MatriImages> matriImageses) {
		getPersistence().cacheResult(matriImageses);
	}

	/**
	 * Creates a new matri images with the primary key. Does not add the matri images to the database.
	 *
	 * @param id the primary key for the new matri images
	 * @return the new matri images
	 */
	public static MatriImages create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the matri images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images that was removed
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public static MatriImages remove(long id)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().remove(id);
	}

	public static MatriImages updateImpl(MatriImages matriImages) {
		return getPersistence().updateImpl(matriImages);
	}

	/**
	 * Returns the matri images with the primary key or throws a <code>NoSuchMatriImagesException</code> if it could not be found.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public static MatriImages findByPrimaryKey(long id)
		throws com.ummat.slayer.exception.NoSuchMatriImagesException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the matri images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images, or <code>null</code> if a matri images with the primary key could not be found
	 */
	public static MatriImages fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the matri imageses.
	 *
	 * @return the matri imageses
	 */
	public static List<MatriImages> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the matri imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @return the range of matri imageses
	 */
	public static List<MatriImages> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the matri imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matri imageses
	 */
	public static List<MatriImages> findAll(
		int start, int end, OrderByComparator<MatriImages> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri imageses
	 * @param end the upper bound of the range of matri imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matri imageses
	 */
	public static List<MatriImages> findAll(
		int start, int end, OrderByComparator<MatriImages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the matri imageses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of matri imageses.
	 *
	 * @return the number of matri imageses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MatriImagesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(MatriImagesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile MatriImagesPersistence _persistence;

}