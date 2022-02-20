package com.made.by.kasih.madebykasih.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseHandler;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.request.UpdateProductRq;
import com.made.by.kasih.madebykasih.response.body.ResProduct;

@Component
public class UpdateProductMapper {
	@Autowired
	@Qualifier("mbkProductHandler")
	private BaseHandler<MbkProduct> mbkProductHandler;
	
	@Autowired
	MbkProductRepository mbkProductRepository;

	/*MAIN*/
	public ResProduct updateProduct(UpdateProductRq request) {
		MbkProduct product = saveToTable(request);
		ResProduct resProduct = mappingToResponse(product);
		return resProduct;
	}

	public MbkProduct saveToTable(UpdateProductRq request) {
		MbkProduct product = mbkProductRepository.getByIdProduct(request.reqProduct.getId());
		try {
			product.setProductCode(request.reqProduct.getProductCode() != null ? request.reqProduct.getProductCode() : product.getProductCode());
			product.setProductName(request.reqProduct.getProductName() != null ? request.reqProduct.getProductName() : product.getProductName());
			product.setProductQty(request.reqProduct.getProductQty() != null ? request.reqProduct.getProductQty() : product.getProductQty());
			product.setProductCategory(request.reqProduct.getProductCategory() != null ? request.reqProduct.getProductCategory() : product.getProductCategory());
			product.setProductColor(request.reqProduct.getProductColor() !=product.getProductColor() ? request.reqProduct.getProductColor() : product.getProductColor());
			product = mbkProductHandler.process(product);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return product;
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