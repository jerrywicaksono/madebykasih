package com.made.by.kasih.madebykasih.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkProductCategory;
import com.made.by.kasih.madebykasih.repository.MbkProductCategoryRepository;

@Component
public class GetListProductCategoryHandler implements BaseListHandler<MbkProductCategory>{
	protected static final Logger log = Logger.getLogger(GetListProductCategoryHandler.class);
	
	@Autowired
	MbkProductCategoryRepository mbkProductCategoryRepository;
	
	@Override
	public List<MbkProductCategory> process(MbkProductCategory object) throws ProcessBaseException {
		List<MbkProductCategory> getListProductCategory = mbkProductCategoryRepository.getAllCategory();
		return getListProductCategory;
	}

}