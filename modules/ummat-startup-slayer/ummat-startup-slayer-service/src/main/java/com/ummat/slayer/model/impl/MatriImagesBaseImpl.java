/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.model.impl;

import com.ummat.slayer.model.MatriImages;
import com.ummat.slayer.service.MatriImagesLocalServiceUtil;

/**
 * The extended model base implementation for the MatriImages service. Represents a row in the &quot;MatriImages&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MatriImagesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriImagesImpl
 * @see MatriImages
 * @generated
 */
public abstract class MatriImagesBaseImpl
	extends MatriImagesModelImpl implements MatriImages {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a matri images model instance should use the <code>MatriImages</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			MatriImagesLocalServiceUtil.addMatriImages(this);
		}
		else {
			MatriImagesLocalServiceUtil.updateMatriImages(this);
		}
	}

}