/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.impl;

import com.liferay.portal.aop.AopService;
import com.ummat.slayer.model.Locality;
import com.ummat.slayer.service.base.LocalityLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ummat.slayer.model.Locality",
	service = AopService.class
)
public class LocalityLocalServiceImpl extends LocalityLocalServiceBaseImpl {
	
	public List<Locality> getLocalityByDistrictId(long districtId) {
		return localityPersistence.findByDistrictId(districtId);
	}
}