/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ummat_startup_details.exception.NoSuchMatriUserException;

import ummat_startup_details.model.MatriUser;

import ummat_startup_details.service.MatriUserLocalServiceUtil;
import ummat_startup_details.service.persistence.MatriUserPersistence;
import ummat_startup_details.service.persistence.MatriUserUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class MatriUserPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "ummat_startup_details.service"));

	@Before
	public void setUp() {
		_persistence = MatriUserUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<MatriUser> iterator = _matriUsers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriUser matriUser = _persistence.create(pk);

		Assert.assertNotNull(matriUser);

		Assert.assertEquals(matriUser.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		MatriUser newMatriUser = addMatriUser();

		_persistence.remove(newMatriUser);

		MatriUser existingMatriUser = _persistence.fetchByPrimaryKey(
			newMatriUser.getPrimaryKey());

		Assert.assertNull(existingMatriUser);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addMatriUser();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriUser newMatriUser = _persistence.create(pk);

		newMatriUser.setUuid(RandomTestUtil.randomString());

		newMatriUser.setUserId(RandomTestUtil.nextLong());

		newMatriUser.setCompanyId(RandomTestUtil.nextLong());

		newMatriUser.setEducation(RandomTestUtil.randomString());

		newMatriUser.setCountryid(RandomTestUtil.nextLong());

		newMatriUser.setCountryName(RandomTestUtil.randomString());

		newMatriUser.setStateid(RandomTestUtil.nextLong());

		newMatriUser.setStateName(RandomTestUtil.randomString());

		newMatriUser.setDistrictid(RandomTestUtil.nextLong());

		newMatriUser.setDistrictName(RandomTestUtil.randomString());

		newMatriUser.setArea(RandomTestUtil.randomString());

		newMatriUser.setJamath(RandomTestUtil.randomString());

		newMatriUser.setMaritalStatus(RandomTestUtil.randomString());

		newMatriUser.setHeight();

		newMatriUser.setWeight(RandomTestUtil.nextDouble());

		newMatriUser.setConvertMuslim(RandomTestUtil.randomString());

		newMatriUser.setPrimaryId(RandomTestUtil.randomString());

		newMatriUser.setImageId(RandomTestUtil.nextLong());

		newMatriUser.setCreateDate(RandomTestUtil.nextDate());

		newMatriUser.setModifiedDate(RandomTestUtil.nextDate());

		newMatriUser.setColor(RandomTestUtil.randomString());

		newMatriUser.setBio(RandomTestUtil.randomString());

		newMatriUser.setMalechild(RandomTestUtil.randomString());

		newMatriUser.setFemalechild(RandomTestUtil.randomString());

		newMatriUser.setMothertongueLanguage(RandomTestUtil.randomString());

		newMatriUser.setLivingPlace(RandomTestUtil.randomString());

		newMatriUser.setMonthlyincome(RandomTestUtil.nextDouble());

		_matriUsers.add(_persistence.update(newMatriUser));

		MatriUser existingMatriUser = _persistence.findByPrimaryKey(
			newMatriUser.getPrimaryKey());

		Assert.assertEquals(
			existingMatriUser.getUuid(), newMatriUser.getUuid());
		Assert.assertEquals(existingMatriUser.getId(), newMatriUser.getId());
		Assert.assertEquals(
			existingMatriUser.getUserId(), newMatriUser.getUserId());
		Assert.assertEquals(
			existingMatriUser.getCompanyId(), newMatriUser.getCompanyId());
		Assert.assertEquals(
			existingMatriUser.getEducation(), newMatriUser.getEducation());
		Assert.assertEquals(
			existingMatriUser.getCountryid(), newMatriUser.getCountryid());
		Assert.assertEquals(
			existingMatriUser.getCountryName(), newMatriUser.getCountryName());
		Assert.assertEquals(
			existingMatriUser.getStateid(), newMatriUser.getStateid());
		Assert.assertEquals(
			existingMatriUser.getStateName(), newMatriUser.getStateName());
		Assert.assertEquals(
			existingMatriUser.getDistrictid(), newMatriUser.getDistrictid());
		Assert.assertEquals(
			existingMatriUser.getDistrictName(),
			newMatriUser.getDistrictName());
		Assert.assertEquals(
			existingMatriUser.getArea(), newMatriUser.getArea());
		Assert.assertEquals(
			existingMatriUser.getJamath(), newMatriUser.getJamath());
		Assert.assertEquals(
			existingMatriUser.getMaritalStatus(),
			newMatriUser.getMaritalStatus());
		Assert.assertEquals(
			existingMatriUser.getHeight(), newMatriUser.getHeight());
		AssertUtils.assertEquals(
			existingMatriUser.getWeight(), newMatriUser.getWeight());
		Assert.assertEquals(
			existingMatriUser.getConvertMuslim(),
			newMatriUser.getConvertMuslim());
		Assert.assertEquals(
			existingMatriUser.getPrimaryId(), newMatriUser.getPrimaryId());
		Assert.assertEquals(
			existingMatriUser.getImageId(), newMatriUser.getImageId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingMatriUser.getCreateDate()),
			Time.getShortTimestamp(newMatriUser.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingMatriUser.getModifiedDate()),
			Time.getShortTimestamp(newMatriUser.getModifiedDate()));
		Assert.assertEquals(
			existingMatriUser.getColor(), newMatriUser.getColor());
		Assert.assertEquals(existingMatriUser.getBio(), newMatriUser.getBio());
		Assert.assertEquals(
			existingMatriUser.getMalechild(), newMatriUser.getMalechild());
		Assert.assertEquals(
			existingMatriUser.getFemalechild(), newMatriUser.getFemalechild());
		Assert.assertEquals(
			existingMatriUser.getMothertongueLanguage(),
			newMatriUser.getMothertongueLanguage());
		Assert.assertEquals(
			existingMatriUser.getLivingPlace(), newMatriUser.getLivingPlace());
		AssertUtils.assertEquals(
			existingMatriUser.getMonthlyincome(),
			newMatriUser.getMonthlyincome());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByFind_matrimonyUsers() throws Exception {
		_persistence.countByFind_matrimonyUsers(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByFind_matrimonyUsers(0L, 0L);
	}

	@Test
	public void testCountByfindByArea() throws Exception {
		_persistence.countByfindByArea("");

		_persistence.countByfindByArea("null");

		_persistence.countByfindByArea((String)null);
	}

	@Test
	public void testCountByfindByDistrict() throws Exception {
		_persistence.countByfindByDistrict("");

		_persistence.countByfindByDistrict("null");

		_persistence.countByfindByDistrict((String)null);
	}

	@Test
	public void testCountByfindByDistricAndAreat() throws Exception {
		_persistence.countByfindByDistricAndAreat("", "");

		_persistence.countByfindByDistricAndAreat("null", "null");

		_persistence.countByfindByDistricAndAreat((String)null, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		MatriUser newMatriUser = addMatriUser();

		MatriUser existingMatriUser = _persistence.findByPrimaryKey(
			newMatriUser.getPrimaryKey());

		Assert.assertEquals(existingMatriUser, newMatriUser);
	}

	@Test(expected = NoSuchMatriUserException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<MatriUser> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"TNUMMAT_MatriUser", "uuid", true, "id", true, "userId", true,
			"companyId", true, "education", true, "countryid", true,
			"countryName", true, "stateid", true, "stateName", true,
			"districtid", true, "districtName", true, "area", true, "jamath",
			true, "maritalStatus", true, "height", true, "weight", true,
			"ConvertMuslim", true, "primaryId", true, "imageId", true,
			"createDate", true, "modifiedDate", true, "color", true, "bio",
			true, "malechild", true, "femalechild", true,
			"MothertongueLanguage", true, "LivingPlace", true, "Monthlyincome",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		MatriUser newMatriUser = addMatriUser();

		MatriUser existingMatriUser = _persistence.fetchByPrimaryKey(
			newMatriUser.getPrimaryKey());

		Assert.assertEquals(existingMatriUser, newMatriUser);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriUser missingMatriUser = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingMatriUser);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		MatriUser newMatriUser1 = addMatriUser();
		MatriUser newMatriUser2 = addMatriUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMatriUser1.getPrimaryKey());
		primaryKeys.add(newMatriUser2.getPrimaryKey());

		Map<Serializable, MatriUser> matriUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, matriUsers.size());
		Assert.assertEquals(
			newMatriUser1, matriUsers.get(newMatriUser1.getPrimaryKey()));
		Assert.assertEquals(
			newMatriUser2, matriUsers.get(newMatriUser2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, MatriUser> matriUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(matriUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		MatriUser newMatriUser = addMatriUser();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMatriUser.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, MatriUser> matriUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, matriUsers.size());
		Assert.assertEquals(
			newMatriUser, matriUsers.get(newMatriUser.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, MatriUser> matriUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(matriUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		MatriUser newMatriUser = addMatriUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMatriUser.getPrimaryKey());

		Map<Serializable, MatriUser> matriUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, matriUsers.size());
		Assert.assertEquals(
			newMatriUser, matriUsers.get(newMatriUser.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			MatriUserLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<MatriUser>() {

				@Override
				public void performAction(MatriUser matriUser) {
					Assert.assertNotNull(matriUser);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		MatriUser newMatriUser = addMatriUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newMatriUser.getId()));

		List<MatriUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		MatriUser existingMatriUser = result.get(0);

		Assert.assertEquals(existingMatriUser, newMatriUser);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<MatriUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		MatriUser newMatriUser = addMatriUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newMatriUser.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		MatriUser newMatriUser = addMatriUser();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newMatriUser.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		MatriUser newMatriUser = addMatriUser();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newMatriUser.getId()));

		List<MatriUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(MatriUser matriUser) {
		Assert.assertEquals(
			Long.valueOf(matriUser.getUserId()),
			ReflectionTestUtil.<Long>invoke(
				matriUser, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "userId"));
		Assert.assertEquals(
			Long.valueOf(matriUser.getCompanyId()),
			ReflectionTestUtil.<Long>invoke(
				matriUser, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "companyId"));
	}

	protected MatriUser addMatriUser() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriUser matriUser = _persistence.create(pk);

		matriUser.setUuid(RandomTestUtil.randomString());

		matriUser.setUserId(RandomTestUtil.nextLong());

		matriUser.setCompanyId(RandomTestUtil.nextLong());

		matriUser.setEducation(RandomTestUtil.randomString());

		matriUser.setCountryid(RandomTestUtil.nextLong());

		matriUser.setCountryName(RandomTestUtil.randomString());

		matriUser.setStateid(RandomTestUtil.nextLong());

		matriUser.setStateName(RandomTestUtil.randomString());

		matriUser.setDistrictid(RandomTestUtil.nextLong());

		matriUser.setDistrictName(RandomTestUtil.randomString());

		matriUser.setArea(RandomTestUtil.randomString());

		matriUser.setJamath(RandomTestUtil.randomString());

		matriUser.setMaritalStatus(RandomTestUtil.randomString());

		matriUser.setHeight();

		matriUser.setWeight(RandomTestUtil.nextDouble());

		matriUser.setConvertMuslim(RandomTestUtil.randomString());

		matriUser.setPrimaryId(RandomTestUtil.randomString());

		matriUser.setImageId(RandomTestUtil.nextLong());

		matriUser.setCreateDate(RandomTestUtil.nextDate());

		matriUser.setModifiedDate(RandomTestUtil.nextDate());

		matriUser.setColor(RandomTestUtil.randomString());

		matriUser.setBio(RandomTestUtil.randomString());

		matriUser.setMalechild(RandomTestUtil.randomString());

		matriUser.setFemalechild(RandomTestUtil.randomString());

		matriUser.setMothertongueLanguage(RandomTestUtil.randomString());

		matriUser.setLivingPlace(RandomTestUtil.randomString());

		matriUser.setMonthlyincome(RandomTestUtil.nextDouble());

		_matriUsers.add(_persistence.update(matriUser));

		return matriUser;
	}

	private List<MatriUser> _matriUsers = new ArrayList<MatriUser>();
	private MatriUserPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}