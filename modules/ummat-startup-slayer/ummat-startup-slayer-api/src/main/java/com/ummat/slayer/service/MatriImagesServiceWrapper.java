/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MatriImagesService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatriImagesService
 * @generated
 */
public class MatriImagesServiceWrapper
	implements MatriImagesService, ServiceWrapper<MatriImagesService> {

	public MatriImagesServiceWrapper() {
		this(null);
	}

	public MatriImagesServiceWrapper(MatriImagesService matriImagesService) {
		_matriImagesService = matriImagesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matriImagesService.getOSGiServiceIdentifier();
	}

	@Override
	public MatriImagesService getWrappedService() {
		return _matriImagesService;
	}

	@Override
	public void setWrappedService(MatriImagesService matriImagesService) {
		_matriImagesService = matriImagesService;
	}

	private MatriImagesService _matriImagesService;

}