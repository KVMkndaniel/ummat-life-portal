/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ummat_startup_details.exception.NoSuchMatriUserException;

import ummat_startup_details.model.MatriUser;
import ummat_startup_details.model.MatriUserTable;
import ummat_startup_details.model.impl.MatriUserImpl;
import ummat_startup_details.model.impl.MatriUserModelImpl;

import ummat_startup_details.service.persistence.MatriUserPersistence;
import ummat_startup_details.service.persistence.MatriUserUtil;
import ummat_startup_details.service.persistence.impl.constants.TNUMMATPersistenceConstants;

/**
 * The persistence implementation for the matri user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MatriUserPersistence.class)
public class MatriUserPersistenceImpl
	extends BasePersistenceImpl<MatriUser> implements MatriUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MatriUserUtil</code> to access the matri user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MatriUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the matri users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri users
	 */
	@Override
	public List<MatriUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<MatriUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<MatriUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<MatriUser> list = null;

		if (useFinderCache) {
			list = (List<MatriUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MatriUser matriUser : list) {
					if (!uuid.equals(matriUser.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MATRIUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<MatriUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	@Override
	public MatriUser findByUuid_First(
			String uuid, OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByUuid_First(uuid, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByUuid_First(
		String uuid, OrderByComparator<MatriUser> orderByComparator) {

		List<MatriUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	@Override
	public MatriUser findByUuid_Last(
			String uuid, OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByUuid_Last(uuid, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByUuid_Last(
		String uuid, OrderByComparator<MatriUser> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MatriUser> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUser[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		uuid = Objects.toString(uuid, "");

		MatriUser matriUser = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			MatriUser[] array = new MatriUserImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, matriUser, uuid, orderByComparator, true);

			array[1] = matriUser;

			array[2] = getByUuid_PrevAndNext(
				session, matriUser, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MatriUser getByUuid_PrevAndNext(
		Session session, MatriUser matriUser, String uuid,
		OrderByComparator<MatriUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MATRIUSER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(matriUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MatriUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matri users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MatriUser matriUser :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(matriUser);
		}
	}

	/**
	 * Returns the number of matri users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri users
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATRIUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"matriUser.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(matriUser.uuid IS NULL OR matriUser.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching matri users
	 */
	@Override
	public List<MatriUser> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<MatriUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<MatriUser> list = null;

		if (useFinderCache) {
			list = (List<MatriUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MatriUser matriUser : list) {
					if (!uuid.equals(matriUser.getUuid()) ||
						(companyId != matriUser.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MATRIUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<MatriUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MatriUser findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the first matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MatriUser> orderByComparator) {

		List<MatriUser> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUser findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the last matri user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MatriUser> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MatriUser> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUser[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		uuid = Objects.toString(uuid, "");

		MatriUser matriUser = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			MatriUser[] array = new MatriUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, matriUser, uuid, companyId, orderByComparator, true);

			array[1] = matriUser;

			array[2] = getByUuid_C_PrevAndNext(
				session, matriUser, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MatriUser getByUuid_C_PrevAndNext(
		Session session, MatriUser matriUser, String uuid, long companyId,
		OrderByComparator<MatriUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MATRIUSER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(matriUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MatriUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matri users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MatriUser matriUser :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(matriUser);
		}
	}

	/**
	 * Returns the number of matri users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching matri users
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MATRIUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"matriUser.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(matriUser.uuid IS NULL OR matriUser.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"matriUser.companyId = ?";

	private FinderPath _finderPathFetchByFind_matrimonyUsers;
	private FinderPath _finderPathCountByFind_matrimonyUsers;

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or throws a <code>NoSuchMatriUserException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	@Override
	public MatriUser findByFind_matrimonyUsers(long userId, long companyId)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByFind_matrimonyUsers(userId, companyId);

		if (matriUser == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", companyId=");
			sb.append(companyId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMatriUserException(sb.toString());
		}

		return matriUser;
	}

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByFind_matrimonyUsers(long userId, long companyId) {
		return fetchByFind_matrimonyUsers(userId, companyId, true);
	}

	/**
	 * Returns the matri user where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByFind_matrimonyUsers(
		long userId, long companyId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, companyId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFind_matrimonyUsers, finderArgs, this);
		}

		if (result instanceof MatriUser) {
			MatriUser matriUser = (MatriUser)result;

			if ((userId != matriUser.getUserId()) ||
				(companyId != matriUser.getCompanyId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MATRIUSER_WHERE);

			sb.append(_FINDER_COLUMN_FIND_MATRIMONYUSERS_USERID_2);

			sb.append(_FINDER_COLUMN_FIND_MATRIMONYUSERS_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(companyId);

				List<MatriUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFind_matrimonyUsers, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId, companyId};
							}

							_log.warn(
								"MatriUserPersistenceImpl.fetchByFind_matrimonyUsers(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MatriUser matriUser = list.get(0);

					result = matriUser;

					cacheResult(matriUser);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MatriUser)result;
		}
	}

	/**
	 * Removes the matri user where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matri user that was removed
	 */
	@Override
	public MatriUser removeByFind_matrimonyUsers(long userId, long companyId)
		throws NoSuchMatriUserException {

		MatriUser matriUser = findByFind_matrimonyUsers(userId, companyId);

		return remove(matriUser);
	}

	/**
	 * Returns the number of matri users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching matri users
	 */
	@Override
	public int countByFind_matrimonyUsers(long userId, long companyId) {
		FinderPath finderPath = _finderPathCountByFind_matrimonyUsers;

		Object[] finderArgs = new Object[] {userId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MATRIUSER_WHERE);

			sb.append(_FINDER_COLUMN_FIND_MATRIMONYUSERS_USERID_2);

			sb.append(_FINDER_COLUMN_FIND_MATRIMONYUSERS_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIND_MATRIMONYUSERS_USERID_2 =
		"matriUser.userId = ? AND ";

	private static final String _FINDER_COLUMN_FIND_MATRIMONYUSERS_COMPANYID_2 =
		"matriUser.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByfindByArea;
	private FinderPath _finderPathWithoutPaginationFindByfindByArea;
	private FinderPath _finderPathCountByfindByArea;

	/**
	 * Returns all the matri users where area = &#63;.
	 *
	 * @param area the area
	 * @return the matching matri users
	 */
	@Override
	public List<MatriUser> findByfindByArea(String area) {
		return findByfindByArea(
			area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUser> findByfindByArea(String area, int start, int end) {
		return findByfindByArea(area, start, end, null);
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
	@Override
	public List<MatriUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return findByfindByArea(area, start, end, orderByComparator, true);
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
	@Override
	public List<MatriUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		area = Objects.toString(area, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByArea;
				finderArgs = new Object[] {area};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByArea;
			finderArgs = new Object[] {area, start, end, orderByComparator};
		}

		List<MatriUser> list = null;

		if (useFinderCache) {
			list = (List<MatriUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MatriUser matriUser : list) {
					if (!area.equals(matriUser.getArea())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MATRIUSER_WHERE);

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArea) {
					queryPos.add(area);
				}

				list = (List<MatriUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	@Override
	public MatriUser findByfindByArea_First(
			String area, OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByfindByArea_First(area, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the first matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByfindByArea_First(
		String area, OrderByComparator<MatriUser> orderByComparator) {

		List<MatriUser> list = findByfindByArea(area, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	@Override
	public MatriUser findByfindByArea_Last(
			String area, OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByfindByArea_Last(area, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the last matri user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByfindByArea_Last(
		String area, OrderByComparator<MatriUser> orderByComparator) {

		int count = countByfindByArea(area);

		if (count == 0) {
			return null;
		}

		List<MatriUser> list = findByfindByArea(
			area, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUser[] findByfindByArea_PrevAndNext(
			long id, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		area = Objects.toString(area, "");

		MatriUser matriUser = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			MatriUser[] array = new MatriUserImpl[3];

			array[0] = getByfindByArea_PrevAndNext(
				session, matriUser, area, orderByComparator, true);

			array[1] = matriUser;

			array[2] = getByfindByArea_PrevAndNext(
				session, matriUser, area, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MatriUser getByfindByArea_PrevAndNext(
		Session session, MatriUser matriUser, String area,
		OrderByComparator<MatriUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MATRIUSER_WHERE);

		boolean bindArea = false;

		if (area.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_3);
		}
		else {
			bindArea = true;

			sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindArea) {
			queryPos.add(area);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(matriUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MatriUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matri users where area = &#63; from the database.
	 *
	 * @param area the area
	 */
	@Override
	public void removeByfindByArea(String area) {
		for (MatriUser matriUser :
				findByfindByArea(
					area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(matriUser);
		}
	}

	/**
	 * Returns the number of matri users where area = &#63;.
	 *
	 * @param area the area
	 * @return the number of matching matri users
	 */
	@Override
	public int countByfindByArea(String area) {
		area = Objects.toString(area, "");

		FinderPath finderPath = _finderPathCountByfindByArea;

		Object[] finderArgs = new Object[] {area};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATRIUSER_WHERE);

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArea) {
					queryPos.add(area);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYAREA_AREA_2 =
		"matriUser.area = ?";

	private static final String _FINDER_COLUMN_FINDBYAREA_AREA_3 =
		"(matriUser.area IS NULL OR matriUser.area = '')";

	private FinderPath _finderPathWithPaginationFindByfindByDistrict;
	private FinderPath _finderPathWithoutPaginationFindByfindByDistrict;
	private FinderPath _finderPathCountByfindByDistrict;

	/**
	 * Returns all the matri users where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @return the matching matri users
	 */
	@Override
	public List<MatriUser> findByfindByDistrict(String districtName) {
		return findByfindByDistrict(
			districtName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end) {

		return findByfindByDistrict(districtName, start, end, null);
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
	@Override
	public List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return findByfindByDistrict(
			districtName, start, end, orderByComparator, true);
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
	@Override
	public List<MatriUser> findByfindByDistrict(
		String districtName, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		districtName = Objects.toString(districtName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByDistrict;
				finderArgs = new Object[] {districtName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByDistrict;
			finderArgs = new Object[] {
				districtName, start, end, orderByComparator
			};
		}

		List<MatriUser> list = null;

		if (useFinderCache) {
			list = (List<MatriUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MatriUser matriUser : list) {
					if (!districtName.equals(matriUser.getDistrictName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MATRIUSER_WHERE);

			boolean bindDistrictName = false;

			if (districtName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_3);
			}
			else {
				bindDistrictName = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDistrictName) {
					queryPos.add(districtName);
				}

				list = (List<MatriUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	@Override
	public MatriUser findByfindByDistrict_First(
			String districtName, OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByfindByDistrict_First(
			districtName, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtName=");
		sb.append(districtName);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByfindByDistrict_First(
		String districtName, OrderByComparator<MatriUser> orderByComparator) {

		List<MatriUser> list = findByfindByDistrict(
			districtName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user
	 * @throws NoSuchMatriUserException if a matching matri user could not be found
	 */
	@Override
	public MatriUser findByfindByDistrict_Last(
			String districtName, OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByfindByDistrict_Last(
			districtName, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtName=");
		sb.append(districtName);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByfindByDistrict_Last(
		String districtName, OrderByComparator<MatriUser> orderByComparator) {

		int count = countByfindByDistrict(districtName);

		if (count == 0) {
			return null;
		}

		List<MatriUser> list = findByfindByDistrict(
			districtName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUser[] findByfindByDistrict_PrevAndNext(
			long id, String districtName,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		districtName = Objects.toString(districtName, "");

		MatriUser matriUser = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			MatriUser[] array = new MatriUserImpl[3];

			array[0] = getByfindByDistrict_PrevAndNext(
				session, matriUser, districtName, orderByComparator, true);

			array[1] = matriUser;

			array[2] = getByfindByDistrict_PrevAndNext(
				session, matriUser, districtName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MatriUser getByfindByDistrict_PrevAndNext(
		Session session, MatriUser matriUser, String districtName,
		OrderByComparator<MatriUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MATRIUSER_WHERE);

		boolean bindDistrictName = false;

		if (districtName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_3);
		}
		else {
			bindDistrictName = true;

			sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDistrictName) {
			queryPos.add(districtName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(matriUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MatriUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matri users where districtName = &#63; from the database.
	 *
	 * @param districtName the district name
	 */
	@Override
	public void removeByfindByDistrict(String districtName) {
		for (MatriUser matriUser :
				findByfindByDistrict(
					districtName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(matriUser);
		}
	}

	/**
	 * Returns the number of matri users where districtName = &#63;.
	 *
	 * @param districtName the district name
	 * @return the number of matching matri users
	 */
	@Override
	public int countByfindByDistrict(String districtName) {
		districtName = Objects.toString(districtName, "");

		FinderPath finderPath = _finderPathCountByfindByDistrict;

		Object[] finderArgs = new Object[] {districtName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATRIUSER_WHERE);

			boolean bindDistrictName = false;

			if (districtName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_3);
			}
			else {
				bindDistrictName = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDistrictName) {
					queryPos.add(districtName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_2 =
		"matriUser.districtName = ?";

	private static final String _FINDER_COLUMN_FINDBYDISTRICT_DISTRICTNAME_3 =
		"(matriUser.districtName IS NULL OR matriUser.districtName = '')";

	private FinderPath _finderPathWithPaginationFindByfindByDistricAndAreat;
	private FinderPath _finderPathWithoutPaginationFindByfindByDistricAndAreat;
	private FinderPath _finderPathCountByfindByDistricAndAreat;

	/**
	 * Returns all the matri users where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @return the matching matri users
	 */
	@Override
	public List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area) {

		return findByfindByDistricAndAreat(
			districtName, area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end) {

		return findByfindByDistricAndAreat(
			districtName, area, start, end, null);
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
	@Override
	public List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator) {

		return findByfindByDistricAndAreat(
			districtName, area, start, end, orderByComparator, true);
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
	@Override
	public List<MatriUser> findByfindByDistricAndAreat(
		String districtName, String area, int start, int end,
		OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		districtName = Objects.toString(districtName, "");
		area = Objects.toString(area, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByfindByDistricAndAreat;
				finderArgs = new Object[] {districtName, area};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByDistricAndAreat;
			finderArgs = new Object[] {
				districtName, area, start, end, orderByComparator
			};
		}

		List<MatriUser> list = null;

		if (useFinderCache) {
			list = (List<MatriUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MatriUser matriUser : list) {
					if (!districtName.equals(matriUser.getDistrictName()) ||
						!area.equals(matriUser.getArea())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MATRIUSER_WHERE);

			boolean bindDistrictName = false;

			if (districtName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_3);
			}
			else {
				bindDistrictName = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_2);
			}

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDistrictName) {
					queryPos.add(districtName);
				}

				if (bindArea) {
					queryPos.add(area);
				}

				list = (List<MatriUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MatriUser findByfindByDistricAndAreat_First(
			String districtName, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByfindByDistricAndAreat_First(
			districtName, area, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtName=");
		sb.append(districtName);

		sb.append(", area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the first matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByfindByDistricAndAreat_First(
		String districtName, String area,
		OrderByComparator<MatriUser> orderByComparator) {

		List<MatriUser> list = findByfindByDistricAndAreat(
			districtName, area, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUser findByfindByDistricAndAreat_Last(
			String districtName, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByfindByDistricAndAreat_Last(
			districtName, area, orderByComparator);

		if (matriUser != null) {
			return matriUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtName=");
		sb.append(districtName);

		sb.append(", area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchMatriUserException(sb.toString());
	}

	/**
	 * Returns the last matri user in the ordered set where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user, or <code>null</code> if a matching matri user could not be found
	 */
	@Override
	public MatriUser fetchByfindByDistricAndAreat_Last(
		String districtName, String area,
		OrderByComparator<MatriUser> orderByComparator) {

		int count = countByfindByDistricAndAreat(districtName, area);

		if (count == 0) {
			return null;
		}

		List<MatriUser> list = findByfindByDistricAndAreat(
			districtName, area, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUser[] findByfindByDistricAndAreat_PrevAndNext(
			long id, String districtName, String area,
			OrderByComparator<MatriUser> orderByComparator)
		throws NoSuchMatriUserException {

		districtName = Objects.toString(districtName, "");
		area = Objects.toString(area, "");

		MatriUser matriUser = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			MatriUser[] array = new MatriUserImpl[3];

			array[0] = getByfindByDistricAndAreat_PrevAndNext(
				session, matriUser, districtName, area, orderByComparator,
				true);

			array[1] = matriUser;

			array[2] = getByfindByDistricAndAreat_PrevAndNext(
				session, matriUser, districtName, area, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MatriUser getByfindByDistricAndAreat_PrevAndNext(
		Session session, MatriUser matriUser, String districtName, String area,
		OrderByComparator<MatriUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MATRIUSER_WHERE);

		boolean bindDistrictName = false;

		if (districtName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_3);
		}
		else {
			bindDistrictName = true;

			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_2);
		}

		boolean bindArea = false;

		if (area.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3);
		}
		else {
			bindArea = true;

			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MatriUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDistrictName) {
			queryPos.add(districtName);
		}

		if (bindArea) {
			queryPos.add(area);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(matriUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MatriUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matri users where districtName = &#63; and area = &#63; from the database.
	 *
	 * @param districtName the district name
	 * @param area the area
	 */
	@Override
	public void removeByfindByDistricAndAreat(
		String districtName, String area) {

		for (MatriUser matriUser :
				findByfindByDistricAndAreat(
					districtName, area, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(matriUser);
		}
	}

	/**
	 * Returns the number of matri users where districtName = &#63; and area = &#63;.
	 *
	 * @param districtName the district name
	 * @param area the area
	 * @return the number of matching matri users
	 */
	@Override
	public int countByfindByDistricAndAreat(String districtName, String area) {
		districtName = Objects.toString(districtName, "");
		area = Objects.toString(area, "");

		FinderPath finderPath = _finderPathCountByfindByDistricAndAreat;

		Object[] finderArgs = new Object[] {districtName, area};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MATRIUSER_WHERE);

			boolean bindDistrictName = false;

			if (districtName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_3);
			}
			else {
				bindDistrictName = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_2);
			}

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDistrictName) {
					queryPos.add(districtName);
				}

				if (bindArea) {
					queryPos.add(area);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_2 =
			"matriUser.districtName = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICTNAME_3 =
			"(matriUser.districtName IS NULL OR matriUser.districtName = '') AND ";

	private static final String _FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2 =
		"matriUser.area = ?";

	private static final String _FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3 =
		"(matriUser.area IS NULL OR matriUser.area = '')";

	public MatriUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MatriUser.class);

		setModelImplClass(MatriUserImpl.class);
		setModelPKClass(long.class);

		setTable(MatriUserTable.INSTANCE);
	}

	/**
	 * Caches the matri user in the entity cache if it is enabled.
	 *
	 * @param matriUser the matri user
	 */
	@Override
	public void cacheResult(MatriUser matriUser) {
		entityCache.putResult(
			MatriUserImpl.class, matriUser.getPrimaryKey(), matriUser);

		finderCache.putResult(
			_finderPathFetchByFind_matrimonyUsers,
			new Object[] {matriUser.getUserId(), matriUser.getCompanyId()},
			matriUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the matri users in the entity cache if it is enabled.
	 *
	 * @param matriUsers the matri users
	 */
	@Override
	public void cacheResult(List<MatriUser> matriUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (matriUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MatriUser matriUser : matriUsers) {
			if (entityCache.getResult(
					MatriUserImpl.class, matriUser.getPrimaryKey()) == null) {

				cacheResult(matriUser);
			}
		}
	}

	/**
	 * Clears the cache for all matri users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MatriUserImpl.class);

		finderCache.clearCache(MatriUserImpl.class);
	}

	/**
	 * Clears the cache for the matri user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MatriUser matriUser) {
		entityCache.removeResult(MatriUserImpl.class, matriUser);
	}

	@Override
	public void clearCache(List<MatriUser> matriUsers) {
		for (MatriUser matriUser : matriUsers) {
			entityCache.removeResult(MatriUserImpl.class, matriUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MatriUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MatriUserImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MatriUserModelImpl matriUserModelImpl) {

		Object[] args = new Object[] {
			matriUserModelImpl.getUserId(), matriUserModelImpl.getCompanyId()
		};

		finderCache.putResult(
			_finderPathCountByFind_matrimonyUsers, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFind_matrimonyUsers, args, matriUserModelImpl);
	}

	/**
	 * Creates a new matri user with the primary key. Does not add the matri user to the database.
	 *
	 * @param id the primary key for the new matri user
	 * @return the new matri user
	 */
	@Override
	public MatriUser create(long id) {
		MatriUser matriUser = new MatriUserImpl();

		matriUser.setNew(true);
		matriUser.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		matriUser.setUuid(uuid);

		matriUser.setCompanyId(CompanyThreadLocal.getCompanyId());

		return matriUser;
	}

	/**
	 * Removes the matri user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user that was removed
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	@Override
	public MatriUser remove(long id) throws NoSuchMatriUserException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the matri user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the matri user
	 * @return the matri user that was removed
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	@Override
	public MatriUser remove(Serializable primaryKey)
		throws NoSuchMatriUserException {

		Session session = null;

		try {
			session = openSession();

			MatriUser matriUser = (MatriUser)session.get(
				MatriUserImpl.class, primaryKey);

			if (matriUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMatriUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(matriUser);
		}
		catch (NoSuchMatriUserException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MatriUser removeImpl(MatriUser matriUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(matriUser)) {
				matriUser = (MatriUser)session.get(
					MatriUserImpl.class, matriUser.getPrimaryKeyObj());
			}

			if (matriUser != null) {
				session.delete(matriUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (matriUser != null) {
			clearCache(matriUser);
		}

		return matriUser;
	}

	@Override
	public MatriUser updateImpl(MatriUser matriUser) {
		boolean isNew = matriUser.isNew();

		if (!(matriUser instanceof MatriUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(matriUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(matriUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in matriUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MatriUser implementation " +
					matriUser.getClass());
		}

		MatriUserModelImpl matriUserModelImpl = (MatriUserModelImpl)matriUser;

		if (Validator.isNull(matriUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			matriUser.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (matriUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				matriUser.setCreateDate(date);
			}
			else {
				matriUser.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!matriUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				matriUser.setModifiedDate(date);
			}
			else {
				matriUser.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(matriUser);
			}
			else {
				matriUser = (MatriUser)session.merge(matriUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MatriUserImpl.class, matriUserModelImpl, false, true);

		cacheUniqueFindersCache(matriUserModelImpl);

		if (isNew) {
			matriUser.setNew(false);
		}

		matriUser.resetOriginalValues();

		return matriUser;
	}

	/**
	 * Returns the matri user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the matri user
	 * @return the matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	@Override
	public MatriUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMatriUserException {

		MatriUser matriUser = fetchByPrimaryKey(primaryKey);

		if (matriUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMatriUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return matriUser;
	}

	/**
	 * Returns the matri user with the primary key or throws a <code>NoSuchMatriUserException</code> if it could not be found.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user
	 * @throws NoSuchMatriUserException if a matri user with the primary key could not be found
	 */
	@Override
	public MatriUser findByPrimaryKey(long id) throws NoSuchMatriUserException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the matri user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the matri user
	 * @return the matri user, or <code>null</code> if a matri user with the primary key could not be found
	 */
	@Override
	public MatriUser fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the matri users.
	 *
	 * @return the matri users
	 */
	@Override
	public List<MatriUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MatriUser> findAll(
		int start, int end, OrderByComparator<MatriUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MatriUser> findAll(
		int start, int end, OrderByComparator<MatriUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<MatriUser> list = null;

		if (useFinderCache) {
			list = (List<MatriUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MATRIUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MATRIUSER;

				sql = sql.concat(MatriUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MatriUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the matri users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MatriUser matriUser : findAll()) {
			remove(matriUser);
		}
	}

	/**
	 * Returns the number of matri users.
	 *
	 * @return the number of matri users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MATRIUSER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MATRIUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MatriUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the matri user persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByFind_matrimonyUsers = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFind_matrimonyUsers",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, true);

		_finderPathCountByFind_matrimonyUsers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFind_matrimonyUsers",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, false);

		_finderPathWithPaginationFindByfindByArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByArea",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"area"}, true);

		_finderPathWithoutPaginationFindByfindByArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByArea",
			new String[] {String.class.getName()}, new String[] {"area"}, true);

		_finderPathCountByfindByArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByArea",
			new String[] {String.class.getName()}, new String[] {"area"},
			false);

		_finderPathWithPaginationFindByfindByDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByDistrict",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"districtName"}, true);

		_finderPathWithoutPaginationFindByfindByDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByDistrict",
			new String[] {String.class.getName()},
			new String[] {"districtName"}, true);

		_finderPathCountByfindByDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByDistrict",
			new String[] {String.class.getName()},
			new String[] {"districtName"}, false);

		_finderPathWithPaginationFindByfindByDistricAndAreat = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByfindByDistricAndAreat",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"districtName", "area"}, true);

		_finderPathWithoutPaginationFindByfindByDistricAndAreat =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByfindByDistricAndAreat",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"districtName", "area"}, true);

		_finderPathCountByfindByDistricAndAreat = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByDistricAndAreat",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"districtName", "area"}, false);

		MatriUserUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		MatriUserUtil.setPersistence(null);

		entityCache.removeCache(MatriUserImpl.class.getName());
	}

	@Override
	@Reference(
		target = TNUMMATPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = TNUMMATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TNUMMATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MATRIUSER =
		"SELECT matriUser FROM MatriUser matriUser";

	private static final String _SQL_SELECT_MATRIUSER_WHERE =
		"SELECT matriUser FROM MatriUser matriUser WHERE ";

	private static final String _SQL_COUNT_MATRIUSER =
		"SELECT COUNT(matriUser) FROM MatriUser matriUser";

	private static final String _SQL_COUNT_MATRIUSER_WHERE =
		"SELECT COUNT(matriUser) FROM MatriUser matriUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "matriUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MatriUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MatriUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MatriUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}