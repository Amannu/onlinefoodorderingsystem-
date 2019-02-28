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
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "order is mandatory")
    private String order;
    
    @NotBlank(message = "quantity is mandatory")
    private String quantity;
    
    @NotBlank(message = "adress is mandatory")
    private String adress;
    
    private String details;
    
    @NotBlank(message = "Please provide a username")
    private String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order=" + order + ", quantity=" + quantity + ", Adress=" + adress + ", Details="
				+ details + ", username=" + username + "]";
	}

	public Order(long id, @NotBlank(message = "order is mandatory") String order,
			@NotBlank(message = "quantity is mandatory") String quantity,
			@NotBlank(message = "adress is mandatory") String adress, String details,
			@NotBlank(message = "Please provide a username") String username) {
		this.id = id;
		this.order = order;
		this.quantity = quantity;
		this.adress = adress;
		this.details = details;
		this.username = username;
	}

	public Order() {
		
	}
    
    
    
}
