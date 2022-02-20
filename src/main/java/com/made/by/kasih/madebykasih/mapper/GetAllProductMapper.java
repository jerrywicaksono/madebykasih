package com.made.by.kasih.madebykasih.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseListHandler;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.response.body.ResProduct;

@Component
public class GetAllProductMapper {
	@Autowired
	@Qualifier("getListProductHandler")
	private BaseListHandler<MbkProduct> getListProductHandler;
	
	@Autowired
	private MbkProductRepository mbkProductRepository;

	/*MAIN*/
	public List<ResProduct> getProduct() {
		List<MbkProduct> product = getFromTable();
		List<ResProduct> resProduct = mappingToResponse(product);
		return resProduct;
	}

	public List<MbkProduct> getFromTable() {
		MbkProduct mbkProduct = new MbkProduct();
		List<MbkProduct> allProduct = null;
		try {
			allProduct = getListProductHandler.process(mbkProduct);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return allProduct;
	}
	
	public List<ResProduct> mappingToResponse(List<MbkProduct> mbkProduct) {
		List<ResProduct> response = new ArrayList<>();
		if(!mbkProduct.isEmpty()){
			for(MbkProduct detail : mbkProduct){
				ResProduct resProduct = new ResProduct();
				resProduct.setProductCode(detail.getProductCode());
				resProduct.setProductName(detail.getProductName());
				resProduct.setProductCategory(detail.getProductCategory());
				resProduct.setProductColor(detail.getProductColor());
				resProduct.setProductQty(detail.getProductQty());
				response.add(resProduct);
			}
		}
		return response;
	}
}