package com.made.by.kasih.madebykasih.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;
import com.made.by.kasih.madebykasih.mapper.ResponseStatusMapper;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

@Component
public class DeleteProductValidator {
	@Autowired
	MbkProductRepository mbkProductRepository;
	
	@Autowired
	ResponseStatusMapper responseStatusMapper;
	
	public ResStatus validate(Long id) {
		ResStatus status = responseStatusMapper.defineStatus(ErrorCodeEnum.SUCCESS);
		
		MbkProduct getProduct = mbkProductRepository.getByIdProduct(id);
		if(getProduct==null){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_NOT_FOUND);
		}
		return status;
	}
}