package com.made.by.kasih.madebykasih.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;

@Component
public class DeleteProductHandler implements BaseHandler<MbkProduct>{
	protected static final Logger log = Logger.getLogger(DeleteProductHandler.class);
	
	@Autowired
	MbkProductRepository mbkProductRepository;
	
	@Override
	public MbkProduct process(MbkProduct object) throws ProcessBaseException {
		mbkProductRepository.delete(object);
		return object;
	}
}