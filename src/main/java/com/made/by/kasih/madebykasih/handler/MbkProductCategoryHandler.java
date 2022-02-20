package com.made.by.kasih.madebykasih.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkProductCategory;
import com.made.by.kasih.madebykasih.repository.MbkProductCategoryRepository;

@Component
public class MbkProductCategoryHandler implements BaseHandler<MbkProductCategory>{
	protected static final Logger log = Logger.getLogger(MbkProductCategoryHandler.class);
	
	@Autowired
	MbkProductCategoryRepository mbkProductCategoryRepository;
	
	@Override
	public MbkProductCategory process(MbkProductCategory object) throws ProcessBaseException {
		object = mbkProductCategoryRepository.save(object);
		return object;
	}
}