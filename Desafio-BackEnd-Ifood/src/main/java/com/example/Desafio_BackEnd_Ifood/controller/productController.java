package com.example.Desafio_BackEnd_Ifood.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Desafio_BackEnd_Ifood.controller.form.ProductForm;
import com.example.Desafio_BackEnd_Ifood.model.entity.Product;
import com.example.Desafio_BackEnd_Ifood.model.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/product")
@RestController
@RequiredArgsConstructor
public class productController {

	 private final ProductService service;
	
	@PostMapping("/salvar")
	public  ResponseEntity<Product> salvar(@RequestBody ProductForm form){
	  var salvar = service.salvar(form);
	  return ResponseEntity.ok().body(salvar);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> listaCategory(){
		var listar = service.listarTodos();
		return ResponseEntity.ok().body(listar);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> editar(@PathVariable("id") String id, 
			@RequestBody ProductForm form){
		var update = service.editar(id, form);
		return ResponseEntity.ok().body(update);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> editar(@PathVariable("id") String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
