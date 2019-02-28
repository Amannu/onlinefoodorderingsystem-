package com.g39.onlinefoodorderingsystem.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@NotBlank(message = "Please provide a username")
    private String username;
	
	  
    @Digits(fraction = 0, integer = 4)
    private int current_balance;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getCurrent_balance() {
		return current_balance;
	}


	public void setCurrent_balance(int current_balance) {
		this.current_balance = current_balance;
	}


	public Payment(long id, @NotBlank(message = "Please provide a username") String username,
			@Digits(fraction = 0, integer = 4) int current_balance) {
		this.id = id;
		this.username = username;
		this.current_balance = current_balance;
	}


	public Payment() {
		
	}
    
}
