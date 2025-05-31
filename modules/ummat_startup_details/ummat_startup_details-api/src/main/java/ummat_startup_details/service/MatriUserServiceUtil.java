/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import ummat_startup_details.model.MatriUser;

/**
 * Provides the remote service utility for MatriUser. This utility wraps
 * <code>ummat_startup_details.service.impl.MatriUserServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserService
 * @generated
 */
public class MatriUserServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ummat_startup_details.service.impl.MatriUserServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MatriUserService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<MatriUserService> _serviceSnapshot =
		new Snapshot<>(MatriUserServiceUtil.class, MatriUserService.class);

	public static MatriUser getMatriUserDetailObj(long userId, long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

}