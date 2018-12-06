package com.test.pasantia.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.pasantia.models.Cliente;
import com.test.pasantia.repository.ClienteRepository;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api")
public class ClienteController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ClienteRepository service;
	
	@GetMapping("/cliente")
	public Iterable<Cliente> listaCliente(){
		return service.findAll();
	}
	
	@PostMapping("/cliente")
	@Transactional
	public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente){
		Cliente newCliente=service.save(cliente);
		
		LOGGER.info("CLIENTE>>>");
		LOGGER.info(cliente.toString());
		return new ResponseEntity<>(newCliente,HttpStatus.OK);
	}
	
	@PutMapping("/cliente")
	@Transactional
	public ResponseEntity<Cliente>editarCliente (@RequestBody Cliente cliente){
		Cliente newCliente=service.save(cliente);
		return new ResponseEntity<>(newCliente,HttpStatus.OK);
	}
	
	@DeleteMapping("/cliente/{id}")
	@Transactional
	public ResponseEntity<?> deletarCliente(@PathVariable Long id){
		service.deleteById(id);
		return new ResponseEntity<>(null,HttpStatus.OK);	
	}
	
	@GetMapping("/cliente/{id}")
	@Transactional
	public ResponseEntity<?> getCliente(@PathVariable Long id){
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);		
	}
	
	@GetMapping("/cliente/login/{login}")
	@Transactional
	public ResponseEntity<?> getCliente(@PathVariable String login){
			return new ResponseEntity<>(service.findByLogin(login), HttpStatus.OK);		
	}
	
	
	
	
	
	
}
