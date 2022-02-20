package com.made.by.kasih.madebykasih.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkCoreUser;
import com.made.by.kasih.madebykasih.repository.MbkCoreUserRepository;

@Component
public class MbkCoreUserHandler implements BaseHandler<MbkCoreUser>{
protected static final Logger log = Logger.getLogger(MbkCoreUserHandler.class);
	
	@Autowired
	MbkCoreUserRepository mbkCoreUserRepository;

	@Override
	public MbkCoreUser process(MbkCoreUser object) throws ProcessBaseException {
		object = mbkCoreUserRepository.save(object);
		return object;
	}
}