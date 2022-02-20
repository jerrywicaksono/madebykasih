package com.made.by.kasih.madebykasih.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.handler.BaseListHandler;
import com.made.by.kasih.madebykasih.model.MbkProductCategory;
import com.made.by.kasih.madebykasih.response.body.ResProductCategory;

@Component
public class GetAllProductCategoryMapper {
	@Autowired
	@Qualifier("getListProductCategoryHandler")
	private BaseListHandler<MbkProductCategory> getListProductCategoryHandler;
	
	/*MAIN*/
	public List<ResProductCategory> getCategory() {
		List<MbkProductCategory> category = getFromTable();
		List<ResProductCategory> resProductCategory = mappingToResponse(category);
		return resProductCategory;
	}

	public List<MbkProductCategory> getFromTable() {
		MbkProductCategory mbkProductCategory = new MbkProductCategory();
		List<MbkProductCategory> allCategory = null;
		try {
			allCategory = getListProductCategoryHandler.process(mbkProductCategory);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return allCategory;
	}
	
	public List<ResProductCategory> mappingToResponse(List<MbkProductCategory> mbkProductCategory) {
		List<ResProductCategory> response = new ArrayList<>();
		if(!mbkProductCategory.isEmpty()){
			for(MbkProductCategory detail : mbkProductCategory){
				ResProductCategory resProductCategory = new ResProductCategory();
				resProductCategory.setCategoryCode(detail.getCategoryCode());
				resProductCategory.setCategoryName(detail.getCategoryName());
				resProductCategory.setCategoryDesc(detail.getCategoryDesc());
				response.add(resProductCategory);
			}
		}
		return response;
	}
}