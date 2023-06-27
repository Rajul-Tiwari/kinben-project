package com.masai.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;

	private String employeeName;
	

	
	private int mobileNumber;

	private String email;

	private String address;

	@Enumerated(EnumType.STRING)
	private  Education education;

	private int totalYear;
	
	private String password;
	
	
}
