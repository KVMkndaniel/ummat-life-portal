/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import com.ummat.slayer.model.Locality;

import java.util.List;

/**
 * Provides the remote service utility for Locality. This utility wraps
 * <code>com.ummat.slayer.service.impl.LocalityServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LocalityService
 * @generated
 */
public class LocalityServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ummat.slayer.service.impl.LocalityServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<Locality> getLocalityByDistrictId(long districtId) {
		return getService().getLocalityByDistrictId(districtId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static LocalityService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LocalityService> _serviceSnapshot =
		new Snapshot<>(LocalityServiceUtil.class, LocalityService.class);

}