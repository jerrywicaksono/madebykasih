package com.made.by.kasih.madebykasih.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.dto.MbkProductDto;
import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;

@Component
public class SortProductHandler implements BaseHandler<MbkProductDto>{
	protected static final Logger log = Logger.getLogger(SortProductHandler.class);
	
	@Autowired
	MbkProductRepository mbkProductRepository;
	
	@Override
	public MbkProductDto process(MbkProductDto object) throws ProcessBaseException {
//		List<MbkProduct> getListProduct = mbkProductRepository.sortProduct(object.getOrder().toString());
		List<MbkProduct> getListProduct=null;
		if(object.getOrder().equals("asc")){
			getListProduct = mbkProductRepository.findAll(Sort.by(Sort.Direction.ASC, "product_name"));
		}else{
			getListProduct = mbkProductRepository.findAll(Sort.by(Sort.Direction.DESC, "product_name"));
		}
		object.setListProduct(getListProduct);
		return object;
	}
}