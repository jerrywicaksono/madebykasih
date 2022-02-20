package com.made.by.kasih.madebykasih.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.dto.MbkProductDto;
import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseHandler;
import com.made.by.kasih.madebykasih.model.MbkProduct;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.response.body.ResProduct;

@Component
public class SortProductMapper {
	@Autowired
	@Qualifier("sortProductHandler")
	private BaseHandler<MbkProductDto> sortProductHandler;
	
	@Autowired
	private MbkProductRepository mbkProductRepository;

	/*MAIN*/
	public List<ResProduct> getProduct(String orderBy, String order) {
		List<MbkProduct> product = getFromTable(orderBy, order);
		List<ResProduct> resProduct = mappingToResponse(product);
		return resProduct;
	}

	public List<MbkProduct> getFromTable(String orderBy, String order) {
		List<MbkProduct> listProduct = new ArrayList<>();
		MbkProductDto dto = new MbkProductDto();

		if(orderBy.equals("name")){
			dto.setOrderBy("product_name");
			if(order.equals("asc")||order.equals("")||order.equals(null)){
				dto.setOrder("asc");	
			}else{
				dto.setOrder("desc");
			}
		}else if(orderBy.equals("code")){
			dto.setOrderBy("product_code");
			if(order.equals("asc")||order.equals("")||order.equals(null)){
				dto.setOrder("asc");	
			}else{
				dto.setOrder("desc");
			}
		}
		
		try {
			MbkProductDto allProduct = sortProductHandler.process(dto);
			listProduct.addAll(allProduct.getListProduct());
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return listProduct;
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