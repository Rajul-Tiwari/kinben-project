package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements employeeService{
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public Employee createEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Employee e=emprepo.save(emp);
		System.out.println(e.getEmployeeName());
		return  e;
	}

	
	
	

	@Override
	public String deleteUser(Integer empId) throws EmployeeException {
		Employee e=emprepo.findById(empId).orElseThrow(()->new RuntimeException("User Does not exist") );
		emprepo.delete(e);
		return "Successfully deleted";
	}



	@Override
	public Employee updateEmployeeById(Employee emp, Integer employeeId) throws EmployeeException {
		Optional<Employee> empl=emprepo.findById(employeeId);
		if(empl.get()!=null) {
			empl.get().setEmployeeName(emp.getEmployeeName());
			empl.get().setEducation(emp.getEducation());
			empl.get().setMobileNumber(emp.getMobileNumber());
			empl.get().setAddress(emp.getAddress());
			
		}
		emprepo.save(empl.get());
		return empl.get();
	}

}
