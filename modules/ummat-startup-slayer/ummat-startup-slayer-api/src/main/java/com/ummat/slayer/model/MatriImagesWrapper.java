/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MatriImages}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriImages
 * @generated
 */
public class MatriImagesWrapper
	extends BaseModelWrapper<MatriImages>
	implements MatriImages, ModelWrapper<MatriImages> {

	public MatriImagesWrapper(MatriImages matriImages) {
		super(matriImages);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dlEntryId", getDlEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long dlEntryId = (Long)attributes.get("dlEntryId");

		if (dlEntryId != null) {
			setDlEntryId(dlEntryId);
		}
	}

	@Override
	public MatriImages cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this matri images.
	 *
	 * @return the company ID of this matri images
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this matri images.
	 *
	 * @return the create date of this matri images
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dl entry ID of this matri images.
	 *
	 * @return the dl entry ID of this matri images
	 */
	@Override
	public long getDlEntryId() {
		return model.getDlEntryId();
	}

	/**
	 * Returns the group ID of this matri images.
	 *
	 * @return the group ID of this matri images
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this matri images.
	 *
	 * @return the ID of this matri images
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this matri images.
	 *
	 * @return the modified date of this matri images
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this matri images.
	 *
	 * @return the primary key of this matri images
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this matri images.
	 *
	 * @return the user ID of this matri images
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this matri images.
	 *
	 * @return the user name of this matri images
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this matri images.
	 *
	 * @return the user uuid of this matri images
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this matri images.
	 *
	 * @return the uuid of this matri images
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this matri images.
	 *
	 * @param companyId the company ID of this matri images
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this matri images.
	 *
	 * @param createDate the create date of this matri images
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dl entry ID of this matri images.
	 *
	 * @param dlEntryId the dl entry ID of this matri images
	 */
	@Override
	public void setDlEntryId(long dlEntryId) {
		model.setDlEntryId(dlEntryId);
	}

	/**
	 * Sets the group ID of this matri images.
	 *
	 * @param groupId the group ID of this matri images
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this matri images.
	 *
	 * @param id the ID of this matri images
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this matri images.
	 *
	 * @param modifiedDate the modified date of this matri images
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this matri images.
	 *
	 * @param primaryKey the primary key of this matri images
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this matri images.
	 *
	 * @param userId the user ID of this matri images
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this matri images.
	 *
	 * @param userName the user name of this matri images
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this matri images.
	 *
	 * @param userUuid the user uuid of this matri images
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this matri images.
	 *
	 * @param uuid the uuid of this matri images
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected MatriImagesWrapper wrap(MatriImages matriImages) {
		return new MatriImagesWrapper(matriImages);
	}

}