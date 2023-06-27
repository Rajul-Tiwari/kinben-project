package com.masai.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.loginDto;
import com.masai.exception.EmployeeException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepository;
import com.masai.repository.EmployeeSessionRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private EmployeeSessionRepository eSessionRepository;
	

	@Override
	public Employee logIntoAccount(loginDto logindto) throws EmployeeException {
java.util.Optional<Employee> loginUser= empRepository.findByEmail(logindto.getEmailId()) ;
		
		if(loginUser.isPresent()) {
			if(loginUser.get().getPassword().equals(logindto.getPassword())) {
				
				CurrentUserSession uSession= new CurrentUserSession();
				
				uSession.setSessionId(loginUser.get().getEmployeeId());
				
				uSession.setUuid(UUID.randomUUID().toString());
				
				eSessionRepository.save(uSession);
				
				return loginUser.get();
				
			}else {
				
				throw new EmployeeException("Invalid Password");
			}
		}else {
			throw new EmployeeException("User not Available");
		}
	}

	@Override
	public String logOutFromAccount(String key) {
		
		CurrentUserSession session= eSessionRepository.findByUuid(key);
		
		if(session==null) {
			return "User not Logged in";
		}
		
		eSessionRepository.delete(session);
		
		LocalDateTime localDateTime= LocalDateTime.now();
		
		return "Logged Out Successfully  "+localDateTime;
	}
	

}
