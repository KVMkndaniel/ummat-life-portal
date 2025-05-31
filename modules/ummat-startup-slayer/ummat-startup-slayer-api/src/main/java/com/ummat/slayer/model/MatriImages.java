/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the MatriImages service. Represents a row in the &quot;MatriImages&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MatriImagesModel
 * @generated
 */
@ImplementationClassName("com.ummat.slayer.model.impl.MatriImagesImpl")
@ProviderType
public interface MatriImages extends MatriImagesModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ummat.slayer.model.impl.MatriImagesImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MatriImages, Long> ID_ACCESSOR =
		new Accessor<MatriImages, Long>() {

			@Override
			public Long get(MatriImages matriImages) {
				return matriImages.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MatriImages> getTypeClass() {
				return MatriImages.class;
			}

		};

}