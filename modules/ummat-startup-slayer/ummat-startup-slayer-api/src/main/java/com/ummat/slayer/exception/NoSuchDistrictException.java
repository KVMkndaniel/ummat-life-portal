/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ummat.slayer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDistrictException extends NoSuchModelException {

	public NoSuchDistrictException() {
	}

	public NoSuchDistrictException(String msg) {
		super(msg);
	}

	public NoSuchDistrictException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchDistrictException(Throwable throwable) {
		super(throwable);
	}

}