/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import com.ummat.slayer.model.District;

import java.util.List;

/**
 * Provides the remote service utility for District. This utility wraps
 * <code>com.ummat.slayer.service.impl.DistrictServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictService
 * @generated
 */
public class DistrictServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ummat.slayer.service.impl.DistrictServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<District> getByRegionCode(String regionCode) {
		return getService().getByRegionCode(regionCode);
	}

	public static List<District> getByRegionId(long regionId) {
		return getService().getByRegionId(regionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DistrictService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DistrictService> _serviceSnapshot =
		new Snapshot<>(DistrictServiceUtil.class, DistrictService.class);

}