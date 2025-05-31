/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DistrictService}.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictService
 * @generated
 */
public class DistrictServiceWrapper
	implements DistrictService, ServiceWrapper<DistrictService> {

	public DistrictServiceWrapper() {
		this(null);
	}

	public DistrictServiceWrapper(DistrictService districtService) {
		_districtService = districtService;
	}

	@Override
	public java.util.List<com.ummat.slayer.model.District> getByRegionCode(
		String regionCode) {

		return _districtService.getByRegionCode(regionCode);
	}

	@Override
	public java.util.List<com.ummat.slayer.model.District> getByRegionId(
		long regionId) {

		return _districtService.getByRegionId(regionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _districtService.getOSGiServiceIdentifier();
	}

	@Override
	public DistrictService getWrappedService() {
		return _districtService;
	}

	@Override
	public void setWrappedService(DistrictService districtService) {
		_districtService = districtService;
	}

	private DistrictService _districtService;

}