package com.made.by.kasih.madebykasih.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;
import com.made.by.kasih.madebykasih.mapper.ResponseStatusMapper;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.request.UpdateProductRq;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

@Component
public class UpdateProductValidator {
	@Autowired
	MbkProductRepository mbkProductRepository;
	
	@Autowired
	ResponseStatusMapper responseStatusMapper;
	
	public ResStatus validate(UpdateProductRq request) {
		ResStatus status = responseStatusMapper.defineStatus(ErrorCodeEnum.SUCCESS);
		
		MbkProduct productExist = mbkProductRepository.getByName(request.reqProduct.getProductName());
		MbkProduct stockProduct = mbkProductRepository.getByIdProduct(request.reqProduct.getId());
		if(productExist!=null){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_ALREADY_EXIST);
		}else if(stockProduct==null){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_NOT_FOUND);
		}
		return status;
	}
}