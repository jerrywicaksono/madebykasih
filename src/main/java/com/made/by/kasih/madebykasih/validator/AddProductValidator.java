package com.made.by.kasih.madebykasih.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;
import com.made.by.kasih.madebykasih.mapper.ResponseStatusMapper;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.request.AddProductRq;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

@Component
public class AddProductValidator {
	@Autowired
	MbkProductRepository mbkProductRepository;
	
	@Autowired
	ResponseStatusMapper responseStatusMapper;
	
	public ResStatus validate(AddProductRq request) {
		ResStatus status = responseStatusMapper.defineStatus(ErrorCodeEnum.SUCCESS);
		
		MbkProduct productExist = mbkProductRepository.getByName(request.reqProduct.getProductName());
		if(productExist!=null){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_ALREADY_EXIST);
		}
		return status;
	}
}