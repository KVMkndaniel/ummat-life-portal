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

import com.ummat.slayer.exception.NoSuchLocalityException;
import com.ummat.slayer.model.Locality;
import com.ummat.slayer.service.LocalityLocalServiceUtil;
import com.ummat.slayer.service.persistence.LocalityPersistence;
import com.ummat.slayer.service.persistence.LocalityUtil;

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
public class LocalityPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.ummat.slayer.service"));

	@Before
	public void setUp() {
		_persistence = LocalityUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Locality> iterator = _localities.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Locality locality = _persistence.create(pk);

		Assert.assertNotNull(locality);

		Assert.assertEquals(locality.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Locality newLocality = addLocality();

		_persistence.remove(newLocality);

		Locality existingLocality = _persistence.fetchByPrimaryKey(
			newLocality.getPrimaryKey());

		Assert.assertNull(existingLocality);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLocality();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Locality newLocality = _persistence.create(pk);

		newLocality.setUuid(RandomTestUtil.randomString());

		newLocality.setRegionId(RandomTestUtil.nextLong());

		newLocality.setDistrictId(RandomTestUtil.nextLong());

		newLocality.setName(RandomTestUtil.randomString());

		newLocality.setActive(RandomTestUtil.randomBoolean());

		newLocality.setCompanyId(RandomTestUtil.nextLong());

		newLocality.setUserId(RandomTestUtil.nextLong());

		newLocality.setCreateDate(RandomTestUtil.nextDate());

		newLocality.setModifiedDate(RandomTestUtil.nextDate());

		_localities.add(_persistence.update(newLocality));

		Locality existingLocality = _persistence.findByPrimaryKey(
			newLocality.getPrimaryKey());

		Assert.assertEquals(existingLocality.getUuid(), newLocality.getUuid());
		Assert.assertEquals(
			existingLocality.getLocalityId(), newLocality.getLocalityId());
		Assert.assertEquals(
			existingLocality.getRegionId(), newLocality.getRegionId());
		Assert.assertEquals(
			existingLocality.getDistrictId(), newLocality.getDistrictId());
		Assert.assertEquals(existingLocality.getName(), newLocality.getName());
		Assert.assertEquals(
			existingLocality.isActive(), newLocality.isActive());
		Assert.assertEquals(
			existingLocality.getCompanyId(), newLocality.getCompanyId());
		Assert.assertEquals(
			existingLocality.getUserId(), newLocality.getUserId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingLocality.getCreateDate()),
			Time.getShortTimestamp(newLocality.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingLocality.getModifiedDate()),
			Time.getShortTimestamp(newLocality.getModifiedDate()));
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
	public void testCountByDistrictId() throws Exception {
		_persistence.countByDistrictId(RandomTestUtil.nextLong());

		_persistence.countByDistrictId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Locality newLocality = addLocality();

		Locality existingLocality = _persistence.findByPrimaryKey(
			newLocality.getPrimaryKey());

		Assert.assertEquals(existingLocality, newLocality);
	}

	@Test(expected = NoSuchLocalityException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Locality> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Locality", "uuid", true, "localityId", true, "regionId", true,
			"districtId", true, "name", true, "active", true, "companyId", true,
			"userId", true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Locality newLocality = addLocality();

		Locality existingLocality = _persistence.fetchByPrimaryKey(
			newLocality.getPrimaryKey());

		Assert.assertEquals(existingLocality, newLocality);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Locality missingLocality = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLocality);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Locality newLocality1 = addLocality();
		Locality newLocality2 = addLocality();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLocality1.getPrimaryKey());
		primaryKeys.add(newLocality2.getPrimaryKey());

		Map<Serializable, Locality> localities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, localities.size());
		Assert.assertEquals(
			newLocality1, localities.get(newLocality1.getPrimaryKey()));
		Assert.assertEquals(
			newLocality2, localities.get(newLocality2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Locality> localities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(localities.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Locality newLocality = addLocality();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLocality.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Locality> localities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, localities.size());
		Assert.assertEquals(
			newLocality, localities.get(newLocality.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Locality> localities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(localities.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Locality newLocality = addLocality();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLocality.getPrimaryKey());

		Map<Serializable, Locality> localities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, localities.size());
		Assert.assertEquals(
			newLocality, localities.get(newLocality.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LocalityLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Locality>() {

				@Override
				public void performAction(Locality locality) {
					Assert.assertNotNull(locality);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Locality newLocality = addLocality();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Locality.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"localityId", newLocality.getLocalityId()));

		List<Locality> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Locality existingLocality = result.get(0);

		Assert.assertEquals(existingLocality, newLocality);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Locality.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"localityId", RandomTestUtil.nextLong()));

		List<Locality> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Locality newLocality = addLocality();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Locality.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("localityId"));

		Object newLocalityId = newLocality.getLocalityId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"localityId", new Object[] {newLocalityId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLocalityId = result.get(0);

		Assert.assertEquals(existingLocalityId, newLocalityId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Locality.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("localityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"localityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Locality addLocality() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Locality locality = _persistence.create(pk);

		locality.setUuid(RandomTestUtil.randomString());

		locality.setRegionId(RandomTestUtil.nextLong());

		locality.setDistrictId(RandomTestUtil.nextLong());

		locality.setName(RandomTestUtil.randomString());

		locality.setActive(RandomTestUtil.randomBoolean());

		locality.setCompanyId(RandomTestUtil.nextLong());

		locality.setUserId(RandomTestUtil.nextLong());

		locality.setCreateDate(RandomTestUtil.nextDate());

		locality.setModifiedDate(RandomTestUtil.nextDate());

		_localities.add(_persistence.update(locality));

		return locality;
	}

	private List<Locality> _localities = new ArrayList<Locality>();
	private LocalityPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}