package com.made.by.kasih.madebykasih.exception;

import org.apache.commons.lang.StringUtils;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;

public class ProcessBaseException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public ProcessBaseException(ErrorCodeEnum errorCode) {
		super(StringUtils.trimToNull(errorCode.getCode())!=null ? errorCode.getCode()+" : "+errorCode.getDefaultMsg() : errorCode.getDefaultMsg());
		this.errorCode = errorCode;
	}
	
	public ProcessBaseException(ErrorCodeEnum errorCode, String message) {
		super(StringUtils.trimToNull(errorCode.getCode())!=null ? errorCode.getCode()+" : "+message : message);
		this.errorCode = errorCode;
		this.errorCode.setDefaultMsg(message);
	}
}