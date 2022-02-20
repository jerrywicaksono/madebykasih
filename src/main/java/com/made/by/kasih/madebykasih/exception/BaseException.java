package com.made.by.kasih.madebykasih.exception;

import org.apache.commons.lang.StringUtils;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;

public class BaseException extends Exception {
	private static final long serialVersionUID = 1L;
	
	protected String errorKey;
	protected ErrorCodeEnum errorCode;
	
	public BaseException(String message) {
        super(message);
    }

	public BaseException(Throwable throwable) {
		super(throwable);
	}
	
    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    public BaseException(String errorCode, String message) {
    	super(StringUtils.trimToNull(errorCode)!=null ? errorCode +" : "+message : message);
    	this.errorKey = errorCode;
    }
    
    public BaseException(String errorCode, String message, Throwable throwable) {
    	super(StringUtils.trimToNull(errorCode)!=null ? errorCode +" : "+message : message, throwable);
    	this.errorKey = errorCode;
    }
    
    /**Declare exception as error code message
     * @param errorCode error code that should provided
     */
	public BaseException(ErrorCodeEnum errorCode) {
		super(StringUtils.trimToNull(errorCode.getCode())!=null ? errorCode.getCode()+" : "+errorCode.getDefaultMsg() : errorCode.getDefaultMsg());
		this.errorCode = errorCode;
	}
	
	/**Declare exception as error code message, and a message to override default message from {@link ErrorCodeEnum}
     * @param errorCode error code that should provided
     * @param message override message
     */
	public BaseException(ErrorCodeEnum errorCode, String message) {
		super(StringUtils.trimToNull(errorCode.getCode())!=null ? errorCode.getCode()+" : "+message : message);
		this.errorCode = errorCode;
		this.errorCode.setDefaultMsg(message);
	}
	
	public ErrorCodeEnum getErrorCode() {
		return errorCode;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
}