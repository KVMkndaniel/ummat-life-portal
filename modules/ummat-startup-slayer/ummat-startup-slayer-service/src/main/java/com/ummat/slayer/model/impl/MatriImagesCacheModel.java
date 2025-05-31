/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.ummat.slayer.model.MatriImages;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MatriImages in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MatriImagesCacheModel
	implements CacheModel<MatriImages>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MatriImagesCacheModel)) {
			return false;
		}

		MatriImagesCacheModel matriImagesCacheModel =
			(MatriImagesCacheModel)object;

		if (id == matriImagesCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dlEntryId=");
		sb.append(dlEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MatriImages toEntityModel() {
		MatriImagesImpl matriImagesImpl = new MatriImagesImpl();

		if (uuid == null) {
			matriImagesImpl.setUuid("");
		}
		else {
			matriImagesImpl.setUuid(uuid);
		}

		matriImagesImpl.setId(id);
		matriImagesImpl.setGroupId(groupId);
		matriImagesImpl.setCompanyId(companyId);
		matriImagesImpl.setUserId(userId);

		if (userName == null) {
			matriImagesImpl.setUserName("");
		}
		else {
			matriImagesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			matriImagesImpl.setCreateDate(null);
		}
		else {
			matriImagesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			matriImagesImpl.setModifiedDate(null);
		}
		else {
			matriImagesImpl.setModifiedDate(new Date(modifiedDate));
		}

		matriImagesImpl.setDlEntryId(dlEntryId);

		matriImagesImpl.resetOriginalValues();

		return matriImagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		dlEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(dlEntryId);
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dlEntryId;

}