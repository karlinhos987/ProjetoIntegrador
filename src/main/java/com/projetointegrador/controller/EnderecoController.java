package com.projetointegrador.controller;

import java.util.List;

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

import com.projetointegrador.model.Endereco;
import com.projetointegrador.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Endereco>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id_endereco}")
	public ResponseEntity<Endereco> GetById(@PathVariable long id_endereco){
		return repository.findById(id_endereco)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("cep/{cep}")
	public ResponseEntity<List<Endereco>> GetByCep (@PathVariable String cep){
		return ResponseEntity.ok(repository.findAllByCepContainingIgnoreCase(cep));
	}
	
	@PostMapping
	public ResponseEntity<Endereco> post (@RequestBody Endereco endereco){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
	}
	
	@PutMapping
	public ResponseEntity<Endereco> put (@RequestBody Endereco endereco){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(endereco));
	}
	
	@DeleteMapping("/{id_endereco}")
	public void delete(@PathVariable long id_endereco) {
		repository.deleteById(id_endereco);
	}
	
}
