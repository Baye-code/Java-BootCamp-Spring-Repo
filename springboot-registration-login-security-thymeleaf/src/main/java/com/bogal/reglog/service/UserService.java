package com.bogal.reglog.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bogal.reglog.model.User;
import com.bogal.reglog.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}
