package com.made.by.kasih.madebykasih.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.made.by.kasih.madebykasih.mapper.AddCustomerMapper;
import com.made.by.kasih.madebykasih.mapper.GetAllCustomerMapper;
import com.made.by.kasih.madebykasih.repository.MbkCustomerRepository;
import com.made.by.kasih.madebykasih.request.AddCustomerRq;
import com.made.by.kasih.madebykasih.response.AddCustomerRs;
import com.made.by.kasih.madebykasih.response.GetAllCustomerRs;
import com.made.by.kasih.madebykasih.response.status.ResStatus;
import com.made.by.kasih.madebykasih.validator.AddCustomerValidator;
import com.made.by.kasih.madebykasih.validator.GetAllCustomerValidator;

@RestController
@RequestMapping("/api/customer")
public class MbkCustomerController {
	@Autowired
	MbkCustomerRepository mbkCustomerRepository;
	
	@Autowired
	GetAllCustomerValidator getAllCustomerValidator;
	
	@Autowired
	AddCustomerValidator addCustomerValidator;
	
	@Autowired
	GetAllCustomerMapper getAllCustomerMapper;
	
	@Autowired
	AddCustomerMapper addCustomerMapper;

	@GetMapping("")
	public GetAllCustomerRs getAllCustomer() {
		GetAllCustomerRs response = new GetAllCustomerRs();
		ResStatus resStatus = getAllCustomerValidator.validate();
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResCustomer(getAllCustomerMapper.getCustomer());
		}
		return response;
	}

	public AddCustomerRs addCustomer(@Valid @RequestBody AddCustomerRq requestBody) {
		AddCustomerRs response = new AddCustomerRs();
		ResStatus resStatus = addCustomerValidator.validate(requestBody);
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResCustomer(addCustomerMapper.addCustomer(requestBody));
		}
		return response;
	}
}