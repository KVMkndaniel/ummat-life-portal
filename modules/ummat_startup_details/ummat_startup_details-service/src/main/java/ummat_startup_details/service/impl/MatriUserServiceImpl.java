/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import ummat_startup_details.service.base.MatriUserServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=tnummat",
		"json.web.service.context.path=MatriUser"
	},
	service = AopService.class
)
public class MatriUserServiceImpl extends MatriUserServiceBaseImpl {
}