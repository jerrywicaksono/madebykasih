package com.made.by.kasih.madebykasih.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseHandler;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.request.AddProductRq;
import com.made.by.kasih.madebykasih.response.body.ResProduct;

@Component
public class AddProductMapper {
	@Autowired
	@Qualifier("mbkProductHandler")
	private BaseHandler<MbkProduct> mbkProductHandler;

	/*MAIN*/
	public ResProduct addProduct(AddProductRq request) {
		MbkProduct product = saveToTable(request);
		ResProduct resProduct = mappingToResponse(product);
		return resProduct;
	}

	public MbkProduct saveToTable(AddProductRq request) {
		MbkProduct newProduct = new MbkProduct();
		try {
			newProduct.setProductCode(request.reqProduct.getProductCode());
			newProduct.setProductName(request.reqProduct.getProductName());
			newProduct.setProductQty(request.reqProduct.getProductQty());
			newProduct.setProductColor(request.reqProduct.getProductColor());
			newProduct.setProductCategory(request.reqProduct.getProductCategory());
			newProduct = mbkProductHandler.process(newProduct);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return newProduct;
	}
	
	public ResProduct mappingToResponse(MbkProduct mbkProduct) {
		ResProduct response = new ResProduct();
		response.setProductCode(mbkProduct.getProductCode());
		response.setProductName(mbkProduct.getProductName());
		response.setProductQty(mbkProduct.getProductQty());
		response.setProductColor(mbkProduct.getProductColor());
		response.setProductCategory(mbkProduct.getProductCategory());
		return response;
	}
}