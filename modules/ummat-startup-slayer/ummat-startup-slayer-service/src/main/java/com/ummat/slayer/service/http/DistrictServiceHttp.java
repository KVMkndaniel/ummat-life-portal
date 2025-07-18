/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.ummat.slayer.service.DistrictServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DistrictServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DistrictServiceHttp {

	public static java.util.List<com.ummat.slayer.model.District> getByRegionId(
		HttpPrincipal httpPrincipal, long regionId) {

		try {
			MethodKey methodKey = new MethodKey(
				DistrictServiceUtil.class, "getByRegionId",
				_getByRegionIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, regionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.ummat.slayer.model.District>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ummat.slayer.model.District>
		getByRegionCode(HttpPrincipal httpPrincipal, String regionCode) {

		try {
			MethodKey methodKey = new MethodKey(
				DistrictServiceUtil.class, "getByRegionCode",
				_getByRegionCodeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, regionCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.ummat.slayer.model.District>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DistrictServiceHttp.class);

	private static final Class<?>[] _getByRegionIdParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _getByRegionCodeParameterTypes1 =
		new Class[] {String.class};

}