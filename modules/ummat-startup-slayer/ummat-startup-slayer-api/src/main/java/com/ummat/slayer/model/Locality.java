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
 * The extended model interface for the Locality service. Represents a row in the &quot;Locality&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LocalityModel
 * @generated
 */
@ImplementationClassName("com.ummat.slayer.model.impl.LocalityImpl")
@ProviderType
public interface Locality extends LocalityModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ummat.slayer.model.impl.LocalityImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Locality, Long> LOCALITY_ID_ACCESSOR =
		new Accessor<Locality, Long>() {

			@Override
			public Long get(Locality locality) {
				return locality.getLocalityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Locality> getTypeClass() {
				return Locality.class;
			}

		};

}