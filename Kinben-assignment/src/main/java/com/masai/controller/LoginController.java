package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.loginDto;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.LoginService;
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Employee> loginAccount(@RequestBody loginDto logindto) throws EmployeeException{
		return new ResponseEntity<Employee>(loginService.logIntoAccount(logindto), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/logOut/{key}")
	public ResponseEntity<String> logOutAccount(@PathVariable String key){
		return new ResponseEntity<>(loginService.logOutFromAccount(key), HttpStatus.OK);
	}
	

}
