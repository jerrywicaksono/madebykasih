package com.made.by.kasih.madebykasih.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.enumerator.ErrorCodeEnum;
import com.made.by.kasih.madebykasih.mapper.ResponseStatusMapper;
import com.made.by.kasih.madebykasih.model.MbkCoreUser;
import com.made.by.kasih.madebykasih.repository.MbkCoreUserRepository;
import com.made.by.kasih.madebykasih.request.AddUserAdminRq;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

@Component
public class RegisterAdminValidator {
	@Autowired
	MbkCoreUserRepository mbkCoreUserRepository;
	
	@Autowired
	ResponseStatusMapper responseStatusMapper;
	
	public ResStatus validate(AddUserAdminRq request) {
		ResStatus status = responseStatusMapper.defineStatus(ErrorCodeEnum.SUCCESS);
		
		MbkCoreUser userExist = mbkCoreUserRepository.getByMsisdn(request.reqCoreUser.getMsisdn());
		if(userExist!=null){
			status = responseStatusMapper.defineStatus(ErrorCodeEnum.DATA_ALREADY_EXIST);
		}
		return status;
	}
}