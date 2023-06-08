package org.java.pizza.controller.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.java.pizza.controller.api.dto.PizzaResponseDto;

import org.java.pizza.pojo.Pizza;
import org.java.pizza.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PizzaApiController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		
		return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
	}

	@GetMapping("/pizze")
	public ResponseEntity<List<Pizza>> getPizza() {
		
		List<Pizza> pizze = pizzaService.findAll();
		
		return new ResponseEntity<>(pizze, HttpStatus.OK);
	}
	
	@PostMapping("/pizze")
	public ResponseEntity<PizzaResponseDto> storePizza(
			@RequestBody Pizza pizza) {
		
//		if (bindingResult.hasErrors()) {
//			
//			return new ResponseEntity<>(
//					new BookResponseDto(bindingResult), 
//					HttpStatus.BAD_REQUEST
//				);
//		}
		
		pizza = pizzaService.save(pizza);
		
		return new ResponseEntity<>(
				new PizzaResponseDto(pizza), 
				HttpStatus.OK);	
	}
	
	@PutMapping("/pizze")
	public ResponseEntity<PizzaResponseDto> updatePizza(
			@RequestBody Pizza pizza
		) {
		
		pizza = pizzaService.save(pizza);
		
		return new ResponseEntity<>(
				new PizzaResponseDto(pizza), 
				HttpStatus.OK);	
	}
	
	@DeleteMapping("/pizze/{id}")
	public ResponseEntity<PizzaResponseDto> deletePizza(
			@PathVariable int id
		) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		
		if (optPizza.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);	
		}
		
		Pizza pizza = optPizza.get();
		pizzaService.deletePizza(id);
		
		return new ResponseEntity<>(
				new PizzaResponseDto(pizza), 
				HttpStatus.OK);	
	}
}
