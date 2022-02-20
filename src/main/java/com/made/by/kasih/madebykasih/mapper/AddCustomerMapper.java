package com.made.by.kasih.madebykasih.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseHandler;
import com.made.by.kasih.madebykasih.model.MbkCustomer;
import com.made.by.kasih.madebykasih.request.AddCustomerRq;
import com.made.by.kasih.madebykasih.response.body.ResCustomer;

@Component
public class AddCustomerMapper {
	@Autowired
	@Qualifier("mbkCustomerHandler")
	private BaseHandler<MbkCustomer> mbkCustomerHandler;

	/*MAIN*/
	public ResCustomer addCustomer(AddCustomerRq request) {
		MbkCustomer customer = saveToTable(request);
		ResCustomer resCustomer = mappingToResponse(customer);
		return resCustomer;
	}

	public MbkCustomer saveToTable(AddCustomerRq request) {
		MbkCustomer newCustomer = new MbkCustomer();
		try {
			newCustomer.setFirstName(request.reqCustomer.getFirstName());
			newCustomer.setLastName(request.reqCustomer.getLastName());
			newCustomer.setAddress(request.reqCustomer.getAddress());
			newCustomer.setEmail(request.reqCustomer.getEmail());
			newCustomer.setMsisdn(request.reqCustomer.getMsisdn());
			newCustomer.setMember(false);
			newCustomer = mbkCustomerHandler.process(newCustomer);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return newCustomer;
	}
	
	public ResCustomer mappingToResponse(MbkCustomer mbkCustomer) {
		ResCustomer response = new ResCustomer();
		response.setFirstName(mbkCustomer.getFirstName());
		response.setLastName(mbkCustomer.getLastName());
		response.setAddress(mbkCustomer.getAddress());
		response.setEmail(mbkCustomer.getEmail());
		response.setMsisdn(mbkCustomer.getMsisdn());
		response.setMember(mbkCustomer.isMember());
		return response;
	}
}
