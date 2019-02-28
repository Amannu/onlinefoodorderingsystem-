package com.g39.onlinefoodorderingsystem.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Feedback {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@NotBlank(message = "Please provide a username")
    private String username;
	
	  
	@NotBlank(message = "Please provide a feedback")
    private String feedback;


	public void setId(long id2) {
		// TODO Auto-generated method stub
		
	}
}
