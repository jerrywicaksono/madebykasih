package com.made.by.kasih.madebykasih.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkUserAdmin;
import com.made.by.kasih.madebykasih.repository.MbkUserAdminRepository;

@Component
public class MbkUserAdminHandler implements BaseHandler<MbkUserAdmin>{
	protected static final Logger log = Logger.getLogger(MbkUserAdminHandler.class);
	
	@Autowired
	MbkUserAdminRepository mbkUserAdminRepository;
	
	@Override
	public MbkUserAdmin process(MbkUserAdmin object) throws ProcessBaseException {
		object = mbkUserAdminRepository.save(object);
		return object;
	}
}