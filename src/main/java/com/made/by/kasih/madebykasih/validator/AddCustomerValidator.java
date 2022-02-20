package com.made.by.kasih.madebykasih.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;
import com.made.by.kasih.madebykasih.mapper.ResponseStatusMapper;
import com.made.by.kasih.madebykasih.model.MbkCustomer;
import com.made.by.kasih.madebykasih.repository.MbkCustomerRepository;
import com.made.by.kasih.madebykasih.request.AddCustomerRq;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

@Component
public class AddCustomerValidator {
	@Autowired
	MbkCustomerRepository mbkCustomerRepository;
	
	@Autowired
	ResponseStatusMapper responseStatusMapper;
	
	public ResStatus validate(AddCustomerRq request) {
		ResStatus status = responseStatusMapper.defineStatus(ErrorCodeEnum.SUCCESS);
		
		MbkCustomer customerExist = mbkCustomerRepository.findByFullName(request.reqCustomer.getFirstName(), request.reqCustomer.getLastName());
		MbkCustomer numberExist = mbkCustomerRepository.findByMsisdn(request.reqCustomer.getMsisdn());
		if(customerExist!=null){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_ALREADY_EXIST);
		}else if(numberExist!=null){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_ALREADY_EXIST);
		}
		return status;
	}
}