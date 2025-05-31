/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LocalityService}.
 *
 * @author Brian Wing Shun Chan
 * @see LocalityService
 * @generated
 */
public class LocalityServiceWrapper
	implements LocalityService, ServiceWrapper<LocalityService> {

	public LocalityServiceWrapper() {
		this(null);
	}

	public LocalityServiceWrapper(LocalityService localityService) {
		_localityService = localityService;
	}

	@Override
	public java.util.List<com.ummat.slayer.model.Locality>
		getLocalityByDistrictId(long districtId) {

		return _localityService.getLocalityByDistrictId(districtId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _localityService.getOSGiServiceIdentifier();
	}

	@Override
	public LocalityService getWrappedService() {
		return _localityService;
	}

	@Override
	public void setWrappedService(LocalityService localityService) {
		_localityService = localityService;
	}

	private LocalityService _localityService;

}