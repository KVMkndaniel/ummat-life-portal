/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.impl;

import com.liferay.portal.aop.AopService;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.base.DistrictServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ummat",
		"json.web.service.context.path=District"
	},
	service = AopService.class
)
public class DistrictServiceImpl extends DistrictServiceBaseImpl {
	
	public List<District> getByRegionId(long regionId) {
		return districtPersistence.findByRegionId(regionId);
	}
	
	public List<District> getByRegionCode(String regionCode) {
		return districtPersistence.findByRegionCode(regionCode);
	}
}