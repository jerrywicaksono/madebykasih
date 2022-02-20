package com.made.by.kasih.madebykasih.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseListHandler;
import com.made.by.kasih.madebykasih.model.MbkCustomer;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.response.body.ResCustomer;

@Component
public class GetAllCustomerMapper {
	@Autowired
	@Qualifier("getAllCustomerHandler")
	private BaseListHandler<MbkCustomer> getAllCustomerHandler;
	
	/*MAIN*/
	public List<ResCustomer> getCustomer() {
		List<MbkCustomer> customer = getFromTable();
		List<ResCustomer> resCustomer = mappingToResponse(customer);
		return resCustomer;
	}

	public List<MbkCustomer> getFromTable() {
		MbkCustomer mbkProduct = new MbkCustomer();
		List<MbkCustomer> allCustomer = null;
		try {
			allCustomer = getAllCustomerHandler.process(mbkProduct);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return allCustomer;
	}
	
	public List<ResCustomer> mappingToResponse(List<MbkCustomer> mbkCustomer) {
		List<ResCustomer> response = new ArrayList<>();
		if(!mbkCustomer.isEmpty()){
			for(MbkCustomer detail : mbkCustomer){
				ResCustomer resCustomer = new ResCustomer();
				resCustomer.setFirstName(detail.getFirstName());
				resCustomer.setLastName(detail.getLastName());
				resCustomer.setAddress(detail.getAddress());
				resCustomer.setEmail(detail.getEmail());
				resCustomer.setMsisdn(detail.getMsisdn());
				resCustomer.setMember(detail.isMember());
				response.add(resCustomer);
			}
		}
		return response;
	}
}
