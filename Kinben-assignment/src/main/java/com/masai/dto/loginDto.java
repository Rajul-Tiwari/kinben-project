package com.masai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class loginDto {
	@NotEmpty (message = "Email Id Can't be Empty.")
	@Email
	private String emailId;
	
	@NotEmpty (message = "Password Can't be Empty.")
	private String password;
}
