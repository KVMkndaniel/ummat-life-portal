/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ummat_startup_details.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

import ummat_startup_details.model.MatriUserTable;
import ummat_startup_details.model.impl.MatriUserImpl;
import ummat_startup_details.model.impl.MatriUserModelImpl;

/**
 * The arguments resolver class for retrieving value from MatriUser.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=ummat_startup_details.model.impl.MatriUserImpl",
		"table.name=TNUMMAT_MatriUser"
	},
	service = ArgumentsResolver.class
)
public class MatriUserModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		MatriUserModelImpl matriUserModelImpl = (MatriUserModelImpl)baseModel;

		long columnBitmask = matriUserModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(matriUserModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= matriUserModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(matriUserModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return MatriUserImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return MatriUserTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		MatriUserModelImpl matriUserModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = matriUserModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = matriUserModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}