package com.masai.service;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.exception.EmployeeException;

import com.masai.model.Employee;

public interface employeeService{
public Employee createEmployee(Employee emp) throws EmployeeException;
    
    
	
	public Employee updateEmployeeById(Employee emp,Integer employeeId) throws EmployeeException;
	
	public String deleteUser(Integer Id) throws EmployeeException;
}
