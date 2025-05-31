/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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

import com.ummat.slayer.exception.NoSuchDistrictException;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.DistrictLocalServiceUtil;
import com.ummat.slayer.service.persistence.DistrictPersistence;
import com.ummat.slayer.service.persistence.DistrictUtil;

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

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class DistrictPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.ummat.slayer.service"));

	@Before
	public void setUp() {
		_persistence = DistrictUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<District> iterator = _districts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		District district = _persistence.create(pk);

		Assert.assertNotNull(district);

		Assert.assertEquals(district.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		District newDistrict = addDistrict();

		_persistence.remove(newDistrict);

		District existingDistrict = _persistence.fetchByPrimaryKey(
			newDistrict.getPrimaryKey());

		Assert.assertNull(existingDistrict);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDistrict();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		District newDistrict = _persistence.create(pk);

		newDistrict.setUuid(RandomTestUtil.randomString());

		newDistrict.setRegionId(RandomTestUtil.nextLong());

		newDistrict.setName(RandomTestUtil.randomString());

		newDistrict.setActive(RandomTestUtil.randomBoolean());

		newDistrict.setRegionCode(RandomTestUtil.randomString());

		newDistrict.setCompanyId(RandomTestUtil.nextLong());

		newDistrict.setUserId(RandomTestUtil.nextLong());

		newDistrict.setCreateDate(RandomTestUtil.nextDate());

		newDistrict.setModifiedDate(RandomTestUtil.nextDate());

		_districts.add(_persistence.update(newDistrict));

		District existingDistrict = _persistence.findByPrimaryKey(
			newDistrict.getPrimaryKey());

		Assert.assertEquals(existingDistrict.getUuid(), newDistrict.getUuid());
		Assert.assertEquals(
			existingDistrict.getDistrictId(), newDistrict.getDistrictId());
		Assert.assertEquals(
			existingDistrict.getRegionId(), newDistrict.getRegionId());
		Assert.assertEquals(existingDistrict.getName(), newDistrict.getName());
		Assert.assertEquals(
			existingDistrict.isActive(), newDistrict.isActive());
		Assert.assertEquals(
			existingDistrict.getRegionCode(), newDistrict.getRegionCode());
		Assert.assertEquals(
			existingDistrict.getCompanyId(), newDistrict.getCompanyId());
		Assert.assertEquals(
			existingDistrict.getUserId(), newDistrict.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDistrict.getCreateDate()),
			Time.getShortTimestamp(newDistrict.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDistrict.getModifiedDate()),
			Time.getShortTimestamp(newDistrict.getModifiedDate()));
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
	public void testCountByRegionId() throws Exception {
		_persistence.countByRegionId(RandomTestUtil.nextLong());

		_persistence.countByRegionId(0L);
	}

	@Test
	public void testCountByRegionCode() throws Exception {
		_persistence.countByRegionCode("");

		_persistence.countByRegionCode("null");

		_persistence.countByRegionCode((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		District newDistrict = addDistrict();

		District existingDistrict = _persistence.findByPrimaryKey(
			newDistrict.getPrimaryKey());

		Assert.assertEquals(existingDistrict, newDistrict);
	}

	@Test(expected = NoSuchDistrictException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<District> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"District", "uuid", true, "districtId", true, "regionId", true,
			"name", true, "active", true, "regionCode", true, "companyId", true,
			"userId", true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		District newDistrict = addDistrict();

		District existingDistrict = _persistence.fetchByPrimaryKey(
			newDistrict.getPrimaryKey());

		Assert.assertEquals(existingDistrict, newDistrict);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		District missingDistrict = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDistrict);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		District newDistrict1 = addDistrict();
		District newDistrict2 = addDistrict();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDistrict1.getPrimaryKey());
		primaryKeys.add(newDistrict2.getPrimaryKey());

		Map<Serializable, District> districts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, districts.size());
		Assert.assertEquals(
			newDistrict1, districts.get(newDistrict1.getPrimaryKey()));
		Assert.assertEquals(
			newDistrict2, districts.get(newDistrict2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, District> districts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(districts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		District newDistrict = addDistrict();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDistrict.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, District> districts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, districts.size());
		Assert.assertEquals(
			newDistrict, districts.get(newDistrict.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, District> districts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(districts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		District newDistrict = addDistrict();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDistrict.getPrimaryKey());

		Map<Serializable, District> districts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, districts.size());
		Assert.assertEquals(
			newDistrict, districts.get(newDistrict.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DistrictLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<District>() {

				@Override
				public void performAction(District district) {
					Assert.assertNotNull(district);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		District newDistrict = addDistrict();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			District.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"districtId", newDistrict.getDistrictId()));

		List<District> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		District existingDistrict = result.get(0);

		Assert.assertEquals(existingDistrict, newDistrict);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			District.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"districtId", RandomTestUtil.nextLong()));

		List<District> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		District newDistrict = addDistrict();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			District.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("districtId"));

		Object newDistrictId = newDistrict.getDistrictId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"districtId", new Object[] {newDistrictId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDistrictId = result.get(0);

		Assert.assertEquals(existingDistrictId, newDistrictId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			District.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("districtId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"districtId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected District addDistrict() throws Exception {
		long pk = RandomTestUtil.nextLong();

		District district = _persistence.create(pk);

		district.setUuid(RandomTestUtil.randomString());

		district.setRegionId(RandomTestUtil.nextLong());

		district.setName(RandomTestUtil.randomString());

		district.setActive(RandomTestUtil.randomBoolean());

		district.setRegionCode(RandomTestUtil.randomString());

		district.setCompanyId(RandomTestUtil.nextLong());

		district.setUserId(RandomTestUtil.nextLong());

		district.setCreateDate(RandomTestUtil.nextDate());

		district.setModifiedDate(RandomTestUtil.nextDate());

		_districts.add(_persistence.update(district));

		return district;
	}

	private List<District> _districts = new ArrayList<District>();
	private DistrictPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}