/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.base.DistrictLocalServiceBaseImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ummat.slayer.model.District",
	service = AopService.class
)
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {
	
	public List<District> getByRegionId(long regionId) {
		return districtPersistence.findByRegionId(regionId);
	}

	public List<District> getByRegionCode(String regionCode) {
		return districtPersistence.findByRegionCode(regionCode);
	}

	public List<UserGroup> getUserGroupsByDistrict(String districtName) throws PortalException {
		return UserGroupLocalServiceUtil.getUserGroups(-1, -1).stream()
				.filter(userGroup -> userGroup.getName().equalsIgnoreCase(districtName)).collect(Collectors.toList());
	}

	public int getUserCountInUserGroup(long userGroupId) throws PortalException {
		return UserLocalServiceUtil.getUserGroupUsersCount(userGroupId);
	}
}

