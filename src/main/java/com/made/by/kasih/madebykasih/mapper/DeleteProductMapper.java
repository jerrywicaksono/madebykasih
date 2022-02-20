package com.made.by.kasih.madebykasih.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.handler.BaseHandler;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.response.body.ResDeleteProduct;

@Component
public class DeleteProductMapper {
	@Autowired
	@Qualifier("mbkProductHandler")
	private BaseHandler<MbkProduct> mbkProductHandler;
	
	@Autowired
	MbkProductRepository mbkProductRepository;

	/*MAIN*/
	public ResDeleteProduct deleteProduct(Long id) {
		MbkProduct product = deleteFromTable(id);
		ResDeleteProduct resDeleteProduct = mappingToResponse(product);
		return resDeleteProduct;
	}

	public MbkProduct deleteFromTable(Long id) {
		MbkProduct getProduct = mbkProductRepository.getByIdProduct(id);
		if(getProduct!=null){
			mbkProductRepository.delete(getProduct);
		}
		MbkProduct getProductAfter = mbkProductRepository.getByIdProduct(id);
		return getProductAfter;
	}
	
	public ResDeleteProduct mappingToResponse(MbkProduct mbkProduct) {
		ResDeleteProduct response = new ResDeleteProduct();		
		if(mbkProduct!=null){
			response.setDeleted(false);
		}else{
			response.setDeleted(true);
		}
		return response;
	}
}