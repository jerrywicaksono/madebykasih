package com.made.by.kasih.madebykasih.mapper;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

@Component
public class ResponseStatusMapper {
	public ResStatus defineStatus(ErrorCodeEnum errorCode) {
		ResStatus resStatus = new ResStatus();
		resStatus.setCode(StringUtils.trimToNull(errorCode.getCode()));
		resStatus.setDescription(StringUtils.trimToNull(errorCode.getDefaultMsg()));
		resStatus.setDatetime(new Date());
		return resStatus;
	}
}