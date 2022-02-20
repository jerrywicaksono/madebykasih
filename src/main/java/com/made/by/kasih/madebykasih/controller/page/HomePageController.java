//package com.made.by.kasih.madebykasih.controller.page;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.made.by.kasih.madebykasih.repository.MbkProductCategoryRepository;
//import com.made.by.kasih.madebykasih.repository.MbkProductRepository;
//
//@Controller
//@RequestMapping("/")
//@PropertySource(ignoreResourceNotFound = true, value = "classpath:templates/Index_id.properties")
//public class HomePageController {
//	@Autowired
//	MbkProductRepository mbkProductRepository;
//	@Autowired
//	MbkProductCategoryRepository mbkProductCategoryRepository;
//	@Value("${home.brand}") 
//	private String brand;
//	@Value("${home.about}") 
//	private String about;
//	@Value("${home.about.detail.est}") 
//	private String aboutDetailEst;
//	@Value("${home.about.detail.first}") 
//	private String aboutDetailFirst;
//	@Value("${home.about.detail.second}") 
//	private String aboutDetailSecond;
//	@Value("${home.products}") 
//	private String products;
//	@Value("${home.contact}") 
//	private String contact;
//	@Value("${home.contact.address}") 
//	private String address;
//	@Value("${home.contact.desc.first}") 
//	private String contactDescFirst;
//	@Value("${home.contact.desc.second}") 
//	private String contactDescSecond;
//	@Value("${home.send.button}") 
//	private String sendButton;
//	
//	
//	@GetMapping("")
//    public String goToHomePage(Model model) {
//		model.addAttribute("name", brand);
//		model.addAttribute("about", about);
//		model.addAttribute("aboutDetailEst", aboutDetailEst);
//		model.addAttribute("aboutDetailFirst", aboutDetailFirst);
//		model.addAttribute("aboutDetailSecond", aboutDetailSecond);
//		model.addAttribute("products", products);
//		model.addAttribute("contact", contact);
//		model.addAttribute("address", address);
//		model.addAttribute("contactDescFirst", contactDescFirst);
//		model.addAttribute("contactDescSecond", contactDescSecond);
//		model.addAttribute("sendButton", sendButton);
//		model.addAttribute("categories", mbkProductCategoryRepository.getAllCategory());
//        return "Index";
//    }
//}