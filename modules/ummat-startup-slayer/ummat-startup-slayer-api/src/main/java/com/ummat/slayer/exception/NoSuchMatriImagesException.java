/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ummat.slayer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMatriImagesException extends NoSuchModelException {

	public NoSuchMatriImagesException() {
	}

	public NoSuchMatriImagesException(String msg) {
		super(msg);
	}

	public NoSuchMatriImagesException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchMatriImagesException(Throwable throwable) {
		super(throwable);
	}

}