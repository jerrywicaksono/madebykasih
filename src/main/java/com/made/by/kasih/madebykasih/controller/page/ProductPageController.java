//package com.made.by.kasih.madebykasih.controller.page;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
//
//@Controller
//@RequestMapping("/product")
//public class ProductPageController {
//	@Autowired
//	MbkProductRepository mbkProductRepository;
//	
//	@GetMapping("/")
//    public String getAllProduct(Model model) {
//        model.addAttribute("products", mbkProductRepository.findAll());
//        return "ViewProductPage";
//    }
//}