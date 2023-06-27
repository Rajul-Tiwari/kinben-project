package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;
import com.masai.service.employeeService;

@RestController
public class EmployeeController {
	@Autowired
	private employeeService empService;
	
	@PostMapping("/addemp")
	public ResponseEntity<Employee> createEmployeeHandler(@RequestBody Employee emp){
		
		Employee u=empService.createEmployee(emp);
		
		return new ResponseEntity<Employee>(u, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<Employee> employeeUser(@RequestBody Employee emp,@PathVariable Integer emplId){
		Employee e=empService.updateEmployeeById(emp, emplId);
		
		return new ResponseEntity<Employee>(e,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployeeByID(@PathVariable("empId") Integer empId){
		String u=empService.deleteUser(empId);
	
		
		return new ResponseEntity<String>(u, HttpStatus.OK);
		
	}
	
}
