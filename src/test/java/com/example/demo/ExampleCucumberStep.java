package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ExampleCucumberStep {
	
	ResponseEntity<String> forEntity;
	@Dado("^que o sistema esta ok$")
	public void que_o_sistema_esta_ok() {
	}
	
	@Quando("^fizer a chamada$")
	public void fizer_a_chamada() {
		RestTemplate restTemplate = new RestTemplate();
		forEntity = restTemplate.getForEntity("http://localhost:8080/example", String.class);
	}
	
	@Entao("^o retorno será (.*)$")
	public void o_retorno_sera_duzentos(int statusCode) {
		assertEquals(statusCode, forEntity.getStatusCodeValue());
	}
}
