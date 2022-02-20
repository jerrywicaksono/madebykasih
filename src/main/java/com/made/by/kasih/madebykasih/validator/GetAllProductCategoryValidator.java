package com.made.by.kasih.madebykasih.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;
import com.made.by.kasih.madebykasih.mapper.ResponseStatusMapper;
import com.made.by.kasih.madebykasih.model.MbkProductCategory;
import com.made.by.kasih.madebykasih.repository.MbkProductCategoryRepository;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

@Component
public class GetAllProductCategoryValidator {
	@Autowired
	MbkProductCategoryRepository mbkProductCategoryRepository;
	
	@Autowired
	ResponseStatusMapper responseStatusMapper;
	
	public ResStatus validate() {
		ResStatus status = responseStatusMapper.defineStatus(ErrorCodeEnum.SUCCESS);
		
		List<MbkProductCategory> allCategory = mbkProductCategoryRepository.getAllCategory();
		if(allCategory.isEmpty()){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_NOT_FOUND);
		}
		return status;
	}
}