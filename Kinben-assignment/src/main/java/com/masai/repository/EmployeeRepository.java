package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Optional<Employee> findByEmail(String userEmail);

}
