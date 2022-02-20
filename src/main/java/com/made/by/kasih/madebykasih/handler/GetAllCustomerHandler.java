package com.made.by.kasih.madebykasih.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkCustomer;
import com.made.by.kasih.madebykasih.repository.MbkCustomerRepository;

@Component
public class GetAllCustomerHandler implements BaseListHandler<MbkCustomer>{
	protected static final Logger log = Logger.getLogger(GetAllCustomerHandler.class);
	
	@Autowired
	MbkCustomerRepository mbkCustomerRepository;
	
	@Override
	public List<MbkCustomer> process(MbkCustomer object) throws ProcessBaseException {
		List<MbkCustomer> getAllCustomer = mbkCustomerRepository.findAll();
		return getAllCustomer;
	}
}