package com.made.by.kasih.madebykasih.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.made.by.kasih.madebykasih.exception.BaseException;

public class BaseController {
	
	protected static final Logger log = Logger.getLogger(BaseController.class);
	
	@Value("${deployment.mode}") 
	public boolean deploymentMode;
	
	private String codeError = null;
	
	public String getCodeError(){
		return this.codeError;
	}

	public void setCodeError(String codeError) {
		if(this.codeError == null){
			this.codeError  = codeError;
		}		
	}
	
	public void throwCodeError() throws BaseException {
		String code = codeError;
		codeError=null;
		if(code!=null){
			throw new BaseException(code);
		}		
	}
}