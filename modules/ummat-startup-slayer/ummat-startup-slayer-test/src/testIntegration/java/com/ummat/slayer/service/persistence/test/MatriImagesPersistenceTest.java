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
import com.liferay.portal.kernel.dao.orm.Session;
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

import com.ummat.slayer.exception.NoSuchMatriImagesException;
import com.ummat.slayer.model.MatriImages;
import com.ummat.slayer.service.MatriImagesLocalServiceUtil;
import com.ummat.slayer.service.persistence.MatriImagesPersistence;
import com.ummat.slayer.service.persistence.MatriImagesUtil;

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
public class MatriImagesPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.ummat.slayer.service"));

	@Before
	public void setUp() {
		_persistence = MatriImagesUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<MatriImages> iterator = _matriImageses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriImages matriImages = _persistence.create(pk);

		Assert.assertNotNull(matriImages);

		Assert.assertEquals(matriImages.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		MatriImages newMatriImages = addMatriImages();

		_persistence.remove(newMatriImages);

		MatriImages existingMatriImages = _persistence.fetchByPrimaryKey(
			newMatriImages.getPrimaryKey());

		Assert.assertNull(existingMatriImages);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addMatriImages();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriImages newMatriImages = _persistence.create(pk);

		newMatriImages.setUuid(RandomTestUtil.randomString());

		newMatriImages.setGroupId(RandomTestUtil.nextLong());

		newMatriImages.setCompanyId(RandomTestUtil.nextLong());

		newMatriImages.setUserId(RandomTestUtil.nextLong());

		newMatriImages.setUserName(RandomTestUtil.randomString());

		newMatriImages.setCreateDate(RandomTestUtil.nextDate());

		newMatriImages.setModifiedDate(RandomTestUtil.nextDate());

		newMatriImages.setDlEntryId(RandomTestUtil.nextLong());

		_matriImageses.add(_persistence.update(newMatriImages));

		MatriImages existingMatriImages = _persistence.findByPrimaryKey(
			newMatriImages.getPrimaryKey());

		Assert.assertEquals(
			existingMatriImages.getUuid(), newMatriImages.getUuid());
		Assert.assertEquals(
			existingMatriImages.getId(), newMatriImages.getId());
		Assert.assertEquals(
			existingMatriImages.getGroupId(), newMatriImages.getGroupId());
		Assert.assertEquals(
			existingMatriImages.getCompanyId(), newMatriImages.getCompanyId());
		Assert.assertEquals(
			existingMatriImages.getUserId(), newMatriImages.getUserId());
		Assert.assertEquals(
			existingMatriImages.getUserName(), newMatriImages.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingMatriImages.getCreateDate()),
			Time.getShortTimestamp(newMatriImages.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingMatriImages.getModifiedDate()),
			Time.getShortTimestamp(newMatriImages.getModifiedDate()));
		Assert.assertEquals(
			existingMatriImages.getDlEntryId(), newMatriImages.getDlEntryId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByuserId() throws Exception {
		_persistence.countByuserId(RandomTestUtil.nextLong());

		_persistence.countByuserId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		MatriImages newMatriImages = addMatriImages();

		MatriImages existingMatriImages = _persistence.findByPrimaryKey(
			newMatriImages.getPrimaryKey());

		Assert.assertEquals(existingMatriImages, newMatriImages);
	}

	@Test(expected = NoSuchMatriImagesException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<MatriImages> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"MatriImages", "uuid", true, "id", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "dlEntryId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		MatriImages newMatriImages = addMatriImages();

		MatriImages existingMatriImages = _persistence.fetchByPrimaryKey(
			newMatriImages.getPrimaryKey());

		Assert.assertEquals(existingMatriImages, newMatriImages);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriImages missingMatriImages = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingMatriImages);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		MatriImages newMatriImages1 = addMatriImages();
		MatriImages newMatriImages2 = addMatriImages();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMatriImages1.getPrimaryKey());
		primaryKeys.add(newMatriImages2.getPrimaryKey());

		Map<Serializable, MatriImages> matriImageses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, matriImageses.size());
		Assert.assertEquals(
			newMatriImages1,
			matriImageses.get(newMatriImages1.getPrimaryKey()));
		Assert.assertEquals(
			newMatriImages2,
			matriImageses.get(newMatriImages2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, MatriImages> matriImageses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(matriImageses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		MatriImages newMatriImages = addMatriImages();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMatriImages.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, MatriImages> matriImageses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, matriImageses.size());
		Assert.assertEquals(
			newMatriImages, matriImageses.get(newMatriImages.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, MatriImages> matriImageses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(matriImageses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		MatriImages newMatriImages = addMatriImages();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMatriImages.getPrimaryKey());

		Map<Serializable, MatriImages> matriImageses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, matriImageses.size());
		Assert.assertEquals(
			newMatriImages, matriImageses.get(newMatriImages.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			MatriImagesLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<MatriImages>() {

				@Override
				public void performAction(MatriImages matriImages) {
					Assert.assertNotNull(matriImages);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		MatriImages newMatriImages = addMatriImages();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriImages.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newMatriImages.getId()));

		List<MatriImages> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		MatriImages existingMatriImages = result.get(0);

		Assert.assertEquals(existingMatriImages, newMatriImages);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriImages.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<MatriImages> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		MatriImages newMatriImages = addMatriImages();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriImages.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newMatriImages.getId();

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
			MatriImages.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		MatriImages newMatriImages = addMatriImages();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newMatriImages.getPrimaryKey()));
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

		MatriImages newMatriImages = addMatriImages();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MatriImages.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newMatriImages.getId()));

		List<MatriImages> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(MatriImages matriImages) {
		Assert.assertEquals(
			matriImages.getUuid(),
			ReflectionTestUtil.invoke(
				matriImages, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(matriImages.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				matriImages, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected MatriImages addMatriImages() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MatriImages matriImages = _persistence.create(pk);

		matriImages.setUuid(RandomTestUtil.randomString());

		matriImages.setGroupId(RandomTestUtil.nextLong());

		matriImages.setCompanyId(RandomTestUtil.nextLong());

		matriImages.setUserId(RandomTestUtil.nextLong());

		matriImages.setUserName(RandomTestUtil.randomString());

		matriImages.setCreateDate(RandomTestUtil.nextDate());

		matriImages.setModifiedDate(RandomTestUtil.nextDate());

		matriImages.setDlEntryId(RandomTestUtil.nextLong());

		_matriImageses.add(_persistence.update(matriImages));

		return matriImages;
	}

	private List<MatriImages> _matriImageses = new ArrayList<MatriImages>();
	private MatriImagesPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}