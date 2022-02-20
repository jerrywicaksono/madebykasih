package com.made.by.kasih.madebykasih.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseHandler;
import com.made.by.kasih.madebykasih.model.MbkProductCategory;
import com.made.by.kasih.madebykasih.request.AddProductCategoryRq;
import com.made.by.kasih.madebykasih.response.body.ResProductCategory;

@Component
public class AddProductCategoryMapper {
	@Autowired
	@Qualifier("mbkProductCategoryHandler")
	private BaseHandler<MbkProductCategory> mbkProductCategoryHandler;

	/*MAIN*/
	public ResProductCategory addProductCategory(AddProductCategoryRq request) {
		MbkProductCategory productCategory = saveToTable(request);
		ResProductCategory resProductCategory = mappingToResponse(productCategory);
		return resProductCategory;
	}

	public MbkProductCategory saveToTable(AddProductCategoryRq request) {
		MbkProductCategory newCategory = new MbkProductCategory();
		try {
			newCategory.setCategoryCode(request.reqProductCategory.getCategoryCode());
			newCategory.setCategoryName(request.reqProductCategory.getCategoryName());
			newCategory.setCategoryDesc(request.reqProductCategory.getCategoryDesc());
			newCategory = mbkProductCategoryHandler.process(newCategory);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return newCategory;
	}
	
	public ResProductCategory mappingToResponse(MbkProductCategory mbkProductCategory) {
		ResProductCategory response = new ResProductCategory();
		response.setCategoryCode(mbkProductCategory.getCategoryCode());
		response.setCategoryName(mbkProductCategory.getCategoryName());
		response.setCategoryDesc(mbkProductCategory.getCategoryDesc());
		return response;
	}
}