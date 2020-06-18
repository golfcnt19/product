package com.java.Product;

import java.util.*;


import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Pro> list() {
		return service.listAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Pro> get(@PathVariable Integer id) {
	    try {
	        Pro product = service.get(id);
	        return new ResponseEntity<Pro>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Pro>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/products")
	public void add(@RequestBody Pro pro) {
		service.save(pro);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Pro product, @PathVariable Integer id) {
	    try {
	        @SuppressWarnings("unused")
			Pro existProduct = service.get(id);
	        service.save(product);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}
	
}
