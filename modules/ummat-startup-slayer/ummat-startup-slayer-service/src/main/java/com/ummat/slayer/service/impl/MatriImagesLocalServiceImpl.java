/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ummat.slayer.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.ummat.slayer.model.MatriImages;
import com.ummat.slayer.service.MatriImagesLocalServiceUtil;
import com.ummat.slayer.service.base.MatriImagesLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ummat.slayer.model.MatriImages",
	service = AopService.class
)
public class MatriImagesLocalServiceImpl
	extends MatriImagesLocalServiceBaseImpl {
	
	public List<MatriImages> getImagesByUserId(long userId){
		return matriImagesPersistence.findByuserId(userId);
	}
	
	public void addMatriImages(long groupId,long companyId, long userId, String userName,long dlEntryId) {
		
		MatriImages matriImage = MatriImagesLocalServiceUtil.createMatriImages(CounterLocalServiceUtil.increment());
		matriImage.setGroupId(groupId);
		matriImage.setCompanyId(companyId);
		matriImage.setUserId(userId);
		matriImage.setUserName(userName);
		matriImage.setCreateDate(new Date());
		matriImage.setModifiedDate(new Date());
		matriImage.setDlEntryId(dlEntryId);
		
		MatriImagesLocalServiceUtil.addMatriImages(matriImage);
	}
}