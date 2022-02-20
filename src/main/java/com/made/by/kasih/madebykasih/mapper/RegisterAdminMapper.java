package com.made.by.kasih.madebykasih.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;
import com.made.by.kasih.madebykasih.generator.UsernamePasswordGenerator;
import com.made.by.kasih.madebykasih.handler.BaseHandler;
import com.made.by.kasih.madebykasih.model.MbkCoreUser;
import com.made.by.kasih.madebykasih.model.MbkUserAdmin;
import com.made.by.kasih.madebykasih.request.AddUserAdminRq;
import com.made.by.kasih.madebykasih.response.body.ResUserAdmin;

@Component
public class RegisterAdminMapper {
	@Autowired
	UsernamePasswordGenerator usernamePasswordGenerator;
	
	@Autowired
	@Qualifier("mbkCoreUserHandler")
	private BaseHandler<MbkCoreUser> mbkCoreUserHandler;
	
	@Autowired
	@Qualifier("mbkUserAdminHandler")
	private BaseHandler<MbkUserAdmin> mbkUserAdminHandler;

	/*MAIN*/
	public ResUserAdmin register(AddUserAdminRq request) {
		MbkCoreUser mcu = registerCoreUser(request);
		MbkUserAdmin addUserAdmin = registerUserAdmin(mcu);
		ResUserAdmin resUserAdmin = mappingToResponse(addUserAdmin);
		return resUserAdmin;
	}

	public MbkCoreUser registerCoreUser(AddUserAdminRq request) {
		MbkCoreUser newUser = new MbkCoreUser();
		try {
			newUser.setFirstName(request.reqCoreUser.getFirstName());
			newUser.setLastName(request.reqCoreUser.getLastName());
			newUser.setMsisdn(request.reqCoreUser.getMsisdn());
			newUser.setAddress(request.reqCoreUser.getAddress());
			newUser.setEmail(request.reqCoreUser.getEmail());
			newUser = mbkCoreUserHandler.process(newUser);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return newUser;
	}

	public MbkUserAdmin registerUserAdmin(MbkCoreUser newUser) {
		MbkUserAdmin newUserAdmin = new MbkUserAdmin();
		try {
			newUserAdmin.setUserId(newUser.getId());
			newUserAdmin.setUsername(usernamePasswordGenerator.generateUsername(newUser.getFirstName().concat(newUser.getLastName())));
			newUserAdmin.setPassword(usernamePasswordGenerator.generatePIN().toString());
			newUserAdmin = mbkUserAdminHandler.process(newUserAdmin);
		} catch (ProcessBaseException e) {
			e.printStackTrace();
		}
		return newUserAdmin;
	}
	
	public ResUserAdmin mappingToResponse(MbkUserAdmin mbkUserAdmin) {
		ResUserAdmin response = new ResUserAdmin();
		response.setUsername(mbkUserAdmin.getUsername());
		response.setPassword(mbkUserAdmin.getPassword());
		return response;
	}
}