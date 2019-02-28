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
@Table(name = "order")
public class Details {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "order is mandatory")
    private String order;
    @NotBlank(message = "details is mandatory")
    private String details;
	public void setId(long id2) {
		// TODO Auto-generated method stub
		
	}
}
