/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MatriUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserService
 * @generated
 */
public class MatriUserServiceWrapper
	implements MatriUserService, ServiceWrapper<MatriUserService> {

	public MatriUserServiceWrapper() {
		this(null);
	}

	public MatriUserServiceWrapper(MatriUserService matriUserService) {
		_matriUserService = matriUserService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matriUserService.getOSGiServiceIdentifier();
	}

	@Override
	public MatriUserService getWrappedService() {
		return _matriUserService;
	}

	@Override
	public void setWrappedService(MatriUserService matriUserService) {
		_matriUserService = matriUserService;
	}

	private MatriUserService _matriUserService;

}