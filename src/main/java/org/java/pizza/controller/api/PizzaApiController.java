package org.java.pizza.controller.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.java.pizza.pojo.Pizza;
import org.java.pizza.service.*;

import java.util.List;


public class PizzaApiController {
	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/pizze")
	public ResponseEntity<List<Pizza>> getPizze(@RequestParam(required = false) String filter) {
	    List<Pizza> pizze;
	    if (filter != null) {
	        pizze = pizzaService.filterPizzeByTitolo(filter);
	    } else {
	        pizze = pizzaService.getAllPizze();
	    }
	    return ResponseEntity.ok(pizze);
	}

	@GetMapping("/pizze/{id}")
	public ResponseEntity<Pizza> getPizzaById(@PathVariable int id) {
	    Pizza pizza = pizzaService.getPizzaById(id);
	    if (pizza != null) {
	        return ResponseEntity.ok(pizza);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PostMapping("/pizze")
	public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
	    Pizza createdPizza = pizzaService.createPizza(pizza);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdPizza);
	}

	@PutMapping("/pizze/{id}")
	public ResponseEntity<Pizza> updatePizza(@PathVariable int id, @RequestBody Pizza updatedPizza) {
	    Pizza pizza = pizzaService.getPizzaById(id);
	    if (pizza != null) {
	        updatedPizza.setId(id);
	        Pizza savedPizza = pizzaService.updatePizza(updatedPizza);
	        return ResponseEntity.ok(savedPizza);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/pizze/{id}")
	public ResponseEntity<Void> deletePizza(@PathVariable int id) {
	    Pizza pizza = pizzaService.getPizzaById(id);
	    if (pizza != null) {
	        pizzaService.deletePizza(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
