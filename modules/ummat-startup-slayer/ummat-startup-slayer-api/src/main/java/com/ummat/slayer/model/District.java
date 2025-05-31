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
 * The extended model interface for the District service. Represents a row in the &quot;District&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictModel
 * @generated
 */
@ImplementationClassName("com.ummat.slayer.model.impl.DistrictImpl")
@ProviderType
public interface District extends DistrictModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ummat.slayer.model.impl.DistrictImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<District, Long> DISTRICT_ID_ACCESSOR =
		new Accessor<District, Long>() {

			@Override
			public Long get(District district) {
				return district.getDistrictId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<District> getTypeClass() {
				return District.class;
			}

		};

}