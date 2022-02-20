package com.made.by.kasih.madebykasih.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.made.by.kasih.madebykasih.mapper.AddProductCategoryMapper;
import com.made.by.kasih.madebykasih.mapper.AddProductMapper;
import com.made.by.kasih.madebykasih.mapper.DeleteProductMapper;
import com.made.by.kasih.madebykasih.mapper.GetAllProductCategoryMapper;
import com.made.by.kasih.madebykasih.mapper.GetAllProductMapper;
import com.made.by.kasih.madebykasih.mapper.RegisterAdminMapper;
import com.made.by.kasih.madebykasih.mapper.SortProductMapper;
import com.made.by.kasih.madebykasih.mapper.UpdateProductMapper;
import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
import com.made.by.kasih.madebykasih.request.AddProductCategoryRq;
import com.made.by.kasih.madebykasih.request.AddProductRq;
import com.made.by.kasih.madebykasih.request.UpdateProductRq;
import com.made.by.kasih.madebykasih.response.AddProductCategoryRs;
import com.made.by.kasih.madebykasih.response.AddProductRs;
import com.made.by.kasih.madebykasih.response.DeleteProductRs;
import com.made.by.kasih.madebykasih.response.GetAllProductCategoryRs;
import com.made.by.kasih.madebykasih.response.GetAllProductRs;
import com.made.by.kasih.madebykasih.response.UpdateProductRs;
import com.made.by.kasih.madebykasih.response.status.ResStatus;
import com.made.by.kasih.madebykasih.validator.AddProductValidator;
import com.made.by.kasih.madebykasih.validator.DeleteProductValidator;
import com.made.by.kasih.madebykasih.validator.GetAllProductCategoryValidator;
import com.made.by.kasih.madebykasih.validator.GetAllProductValidator;
import com.made.by.kasih.madebykasih.validator.UpdateProductValidator;

@RestController
@RequestMapping("/api/product")
public class MbkProductController {
	@Autowired
	MbkProductRepository mbkProductRepository;
	
	@Autowired
	AddProductValidator addProductValidator;
	
	@Autowired
	GetAllProductValidator getAllProductValidator;
	
	@Autowired
	DeleteProductValidator deleteProductValidator;
	
	@Autowired
	GetAllProductCategoryValidator getAllProductCategoryValidator;
	
	@Autowired
	AddProductMapper addProductMapper;
	
	@Autowired
	UpdateProductMapper updateProductMapper;
	
	@Autowired
	DeleteProductMapper deleteProductMapper;
	
	@Autowired
	GetAllProductMapper getAllProductMapper;
	
	@Autowired
	GetAllProductCategoryMapper getAllProductCategoryMapper;
	
	@Autowired
	AddProductCategoryMapper addProductCategoryMapper;
	
	@Autowired
	SortProductMapper sortProductMapper;
	
	@Autowired
	UpdateProductValidator updateProductValidator;
	
	@Autowired
	RegisterAdminMapper registerAdminMapper;

	@GetMapping("")
	public GetAllProductRs getAllProduct() {
		GetAllProductRs response = new GetAllProductRs();
		ResStatus resStatus = getAllProductValidator.validate();
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResProduct(getAllProductMapper.getProduct());
		}
		return response;
	}
	
	@GetMapping("/category")
	public GetAllProductCategoryRs getAllProductCategory() {
		GetAllProductCategoryRs response = new GetAllProductCategoryRs();
		ResStatus resStatus = getAllProductCategoryValidator.validate();
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResProductCategory(getAllProductCategoryMapper.getCategory());
		}
		return response;
	}
	
//	@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@PostMapping("/category/add")
	public AddProductCategoryRs addProductCategoryCategory(@Valid @RequestBody AddProductCategoryRq requestBody) {
//	public AddProductCategoryRs addProductCategoryCategory(@PathVariable("categoryCode") String categoryCode, @PathVariable("categoryName") String categoryName, @PathVariable("categoryDesc") String categoryDesc) {
		AddProductCategoryRs response = new AddProductCategoryRs();
//		AddProductCategoryRq requestBody = new AddProductCategoryRq();
//		requestBody.reqProductCategory.setCategoryCode(categoryCode);
//		requestBody.reqProductCategory.setCategoryName(categoryName);
//		requestBody.reqProductCategory.setCategoryDesc(categoryDesc);
		ResStatus resStatus = getAllProductCategoryValidator.validate();
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResProductCategory(addProductCategoryMapper.addProductCategory(requestBody));
		}
		return response;
	}
	
	@PostMapping("/add")
	public AddProductRs addProduct(@Valid @RequestBody AddProductRq requestBody) {
		AddProductRs response = new AddProductRs();
		ResStatus resStatus = addProductValidator.validate(requestBody);
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResProduct(addProductMapper.addProduct(requestBody));
		}
		return response;
	}

	@PostMapping("/update")
	public UpdateProductRs updateProduct(@Valid @RequestBody UpdateProductRq requestBody) {
		UpdateProductRs response = new UpdateProductRs();
		ResStatus resStatus = updateProductValidator.validate(requestBody);
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResProduct(updateProductMapper.updateProduct(requestBody));
		}
		return response;
	}
	
	@GetMapping("/delete/{id}")
	public DeleteProductRs deleteProduct(@PathVariable(value = "id") Long id) {
		DeleteProductRs response = new DeleteProductRs();
		ResStatus resStatus = deleteProductValidator.validate(id);
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResDeleteProduct(deleteProductMapper.deleteProduct(id));
		}
		return response;
	}

//	@GetMapping("/sort")
//	public List<MbkProduct> sortProduct(@RequestParam(value = "productName") String productName) {
//		return mbkProductRepository.findByProductName(productName);
//	}
	
	@GetMapping("/sort/name/{order}")
	public GetAllProductRs sortProductByName(@PathVariable(value = "order") String order) {
		GetAllProductRs response = new GetAllProductRs();
		ResStatus resStatus = getAllProductValidator.validate();
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResProduct(sortProductMapper.getProduct("name", order));
		}
		return response;
	}

	@GetMapping("/sort/code/{order}")
	public GetAllProductRs sortProductByCode(@PathVariable(value = "order") String order) {
		GetAllProductRs response = new GetAllProductRs();
		ResStatus resStatus = getAllProductValidator.validate();
		if(!resStatus.getCode().equals("1000")){
			response.setResStatus(resStatus);
			return response;
		}else{
			response.setResStatus(resStatus);
			response.setResProduct(sortProductMapper.getProduct("code", order));
		}
		return response;
	}
}