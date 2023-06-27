package com.masai.service;

import com.masai.dto.loginDto;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface LoginService {
	 public Employee logIntoAccount(loginDto logindto) throws EmployeeException;
		
		public String logOutFromAccount(String key);
}
