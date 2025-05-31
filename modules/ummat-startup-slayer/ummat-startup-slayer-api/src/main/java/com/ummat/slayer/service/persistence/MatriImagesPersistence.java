/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.ummat.slayer.exception.NoSuchMatriImagesException;
import com.ummat.slayer.model.MatriImages;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the matri images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriImagesUtil
 * @generated
 */
@ProviderType
public interface MatriImagesPersistence extends BasePersistence<MatriImages> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MatriImagesUtil} to access the matri images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the matri imageses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri imageses
	 */
	public java.util.List<MatriImages> findByUuid(String uuid);

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
	public java.util.List<MatriImages> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MatriImages> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

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
	public java.util.List<MatriImages> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public MatriImages findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public MatriImages findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

	/**
	 * Returns the matri imageses before and after the current matri images in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current matri images
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri images
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public MatriImages[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Removes all the matri imageses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of matri imageses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri imageses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the matri images where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMatriImagesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public MatriImages findByUUID_G(String uuid, long groupId)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the matri images where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the matri images where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the matri images where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matri images that was removed
	 */
	public MatriImages removeByUUID_G(String uuid, long groupId)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the number of matri imageses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching matri imageses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the matri imageses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching matri imageses
	 */
	public java.util.List<MatriImages> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<MatriImages> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MatriImages> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

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
	public java.util.List<MatriImages> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public MatriImages findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the first matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public MatriImages findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the last matri images in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

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
	public MatriImages[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Removes all the matri imageses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of matri imageses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching matri imageses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the matri imageses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching matri imageses
	 */
	public java.util.List<MatriImages> findByuserId(long userId);

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
	public java.util.List<MatriImages> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<MatriImages> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

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
	public java.util.List<MatriImages> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public MatriImages findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the first matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

	/**
	 * Returns the last matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images
	 * @throws NoSuchMatriImagesException if a matching matri images could not be found
	 */
	public MatriImages findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the last matri images in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri images, or <code>null</code> if a matching matri images could not be found
	 */
	public MatriImages fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

	/**
	 * Returns the matri imageses before and after the current matri images in the ordered set where userId = &#63;.
	 *
	 * @param id the primary key of the current matri images
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri images
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public MatriImages[] findByuserId_PrevAndNext(
			long id, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
				orderByComparator)
		throws NoSuchMatriImagesException;

	/**
	 * Removes all the matri imageses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of matri imageses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching matri imageses
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the matri images in the entity cache if it is enabled.
	 *
	 * @param matriImages the matri images
	 */
	public void cacheResult(MatriImages matriImages);

	/**
	 * Caches the matri imageses in the entity cache if it is enabled.
	 *
	 * @param matriImageses the matri imageses
	 */
	public void cacheResult(java.util.List<MatriImages> matriImageses);

	/**
	 * Creates a new matri images with the primary key. Does not add the matri images to the database.
	 *
	 * @param id the primary key for the new matri images
	 * @return the new matri images
	 */
	public MatriImages create(long id);

	/**
	 * Removes the matri images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images that was removed
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public MatriImages remove(long id) throws NoSuchMatriImagesException;

	public MatriImages updateImpl(MatriImages matriImages);

	/**
	 * Returns the matri images with the primary key or throws a <code>NoSuchMatriImagesException</code> if it could not be found.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images
	 * @throws NoSuchMatriImagesException if a matri images with the primary key could not be found
	 */
	public MatriImages findByPrimaryKey(long id)
		throws NoSuchMatriImagesException;

	/**
	 * Returns the matri images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the matri images
	 * @return the matri images, or <code>null</code> if a matri images with the primary key could not be found
	 */
	public MatriImages fetchByPrimaryKey(long id);

	/**
	 * Returns all the matri imageses.
	 *
	 * @return the matri imageses
	 */
	public java.util.List<MatriImages> findAll();

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
	public java.util.List<MatriImages> findAll(int start, int end);

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
	public java.util.List<MatriImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator);

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
	public java.util.List<MatriImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriImages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the matri imageses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of matri imageses.
	 *
	 * @return the number of matri imageses
	 */
	public int countAll();

}