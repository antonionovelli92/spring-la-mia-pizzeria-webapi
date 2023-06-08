package org.java.pizza.controller.api.dto;




import org.java.pizza.pojo.Pizza;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

public class PizzaFormDto {

	@Valid
	private Pizza pizza;
	
	MultipartFile image;

	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public boolean hasImage() {
		
		return getImage() != null;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		
		return getPizza() + "\npicture: " + 
				(hasImage() ? getImage().getOriginalFilename() : "empty")
		;
	}
}