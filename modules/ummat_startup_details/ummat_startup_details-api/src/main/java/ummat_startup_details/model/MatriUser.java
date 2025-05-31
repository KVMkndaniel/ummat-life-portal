/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the MatriUser service. Represents a row in the &quot;TNUMMAT_MatriUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserModel
 * @generated
 */
@ImplementationClassName("ummat_startup_details.model.impl.MatriUserImpl")
@ProviderType
public interface MatriUser extends MatriUserModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>ummat_startup_details.model.impl.MatriUserImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MatriUser, Long> ID_ACCESSOR =
		new Accessor<MatriUser, Long>() {

			@Override
			public Long get(MatriUser matriUser) {
				return matriUser.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MatriUser> getTypeClass() {
				return MatriUser.class;
			}

		};

}