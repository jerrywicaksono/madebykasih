package com.made.by.kasih.madebykasih.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkCustomer;
import com.made.by.kasih.madebykasih.repository.MbkCustomerRepository;

@Component
public class MbkCustomerHandler implements BaseHandler<MbkCustomer>{
	protected static final Logger log = Logger.getLogger(MbkCustomerHandler.class);
	
	@Autowired
	MbkCustomerRepository mbkCustomerRepository;
	
	@Override
	public MbkCustomer process(MbkCustomer object) throws ProcessBaseException {
		object = mbkCustomerRepository.save(object);
		return object;
	}
}