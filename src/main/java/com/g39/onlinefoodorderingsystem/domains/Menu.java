package com.g39.onlinefoodorderingsystem.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "menu")
public class Menu {
	
	     
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    
	    @NotBlank(message = "food name is mandatory")
	    private String foodName;
	     
	    @Digits(fraction = 0, integer = 2)
	    private int price;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFoodName() {
			return foodName;
		}

		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public Menu() {
			
		}

		public Menu(long id, @NotBlank(message = "food name is mandatory") String foodName,
				@Digits(fraction = 0, integer = 2) int price) {
			this.id = id;
			this.foodName = foodName;
			this.price = price;
		}

		@Override
		public String toString() {
			return "Menu [id=" + id + ", foodName=" + foodName + ", price=" + price + "]";
		}
		
	    
	    
}
