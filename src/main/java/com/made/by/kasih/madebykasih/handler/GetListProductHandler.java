package com.made.by.kasih.madebykasih.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;

@Component
public class GetListProductHandler implements BaseListHandler<MbkProduct>{
	protected static final Logger log = Logger.getLogger(GetListProductHandler.class);
	
	@Autowired
	MbkProductRepository mbkProductRepository;
	
	@Override
	public List<MbkProduct> process(MbkProduct object) throws ProcessBaseException {
		List<MbkProduct> getListProduct = mbkProductRepository.findAll();
		return getListProduct;
	}
}