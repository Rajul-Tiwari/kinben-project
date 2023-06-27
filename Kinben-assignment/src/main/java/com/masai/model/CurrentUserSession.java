package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class CurrentUserSession {
	@Id
	private int sessionId;
	
	private String uuid;
	private LocalDateTime date= LocalDateTime.now();

}
