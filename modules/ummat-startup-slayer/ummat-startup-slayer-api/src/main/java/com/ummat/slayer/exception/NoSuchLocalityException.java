/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ummat.slayer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLocalityException extends NoSuchModelException {

	public NoSuchLocalityException() {
	}

	public NoSuchLocalityException(String msg) {
		super(msg);
	}

	public NoSuchLocalityException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchLocalityException(Throwable throwable) {
		super(throwable);
	}

}