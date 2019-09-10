package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/example")
public class Controller {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public ResponseEntity<String> get(){
		
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/exampe/Teste", String.class);
		return ResponseEntity.ok(forEntity.getBody());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getyId(@PathVariable String id){
		return ResponseEntity.ok("{\"id\" : \"" + id +"\"}");
	}
}
