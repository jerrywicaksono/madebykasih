//package com.made.by.kasih.madebykasih.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.made.by.kasih.madebykasih.exception.BaseException;
//import com.made.by.kasih.madebykasih.generator.UsernamePasswordGenerator;
//import com.made.by.kasih.madebykasih.mapper.RegisterAdminMapper;
//import com.made.by.kasih.madebykasih.mapper.ResponseStatusMapper;
//import com.made.by.kasih.madebykasih.model.MbkUserAdmin;
//import com.made.by.kasih.madebykasih.repository.MbkCoreUserRepository;
//import com.made.by.kasih.madebykasih.repository.MbkUserAdminRepository;
//import com.made.by.kasih.madebykasih.request.AddUserAdminRq;
//import com.made.by.kasih.madebykasih.response.AddUserAdminRs;
//import com.made.by.kasih.madebykasih.response.status.ResStatus;
//import com.made.by.kasih.madebykasih.validator.RegisterAdminValidator;
//
//@RestController
//@RequestMapping("/api/admin")
//public class MbkUserAdminController extends BaseController {
//	@Autowired
//	MbkUserAdminRepository mbkUserAdminRepository;
//	@Autowired
//	RegisterAdminValidator registerAdminValidator;
//	@Autowired
//	RegisterAdminMapper registerAdminMapper;
//
//	@GetMapping("")
//	public List<MbkUserAdmin> getAllAdmin() {
//		return mbkUserAdminRepository.findAll();
//	}
//
//	@PostMapping("/add")
//	public AddUserAdminRs addUserAdmin(@Valid @RequestBody AddUserAdminRq requestBody) throws BaseException{
//		AddUserAdminRs response = new AddUserAdminRs();
//		ResStatus resStatus = new ResStatus();
//		resStatus = registerAdminValidator.validate(requestBody);
//		if(!resStatus.getCode().equals("1000")){
//			response.setResStatus(resStatus);
//			return response;
//		}else{
//			response.setResStatus(resStatus);
//			response.setResUserAdmin(registerAdminMapper.register(requestBody));
//		}
//		return response;
//	}
//}