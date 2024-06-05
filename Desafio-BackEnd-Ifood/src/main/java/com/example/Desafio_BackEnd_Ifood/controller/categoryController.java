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

import com.example.Desafio_BackEnd_Ifood.controller.dto.InforCategoryDTO;
import com.example.Desafio_BackEnd_Ifood.controller.form.CategoryForm;
import com.example.Desafio_BackEnd_Ifood.model.entity.Category;
import com.example.Desafio_BackEnd_Ifood.model.service.CategoryService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class categoryController {
	
	private final CategoryService service;
	
	@PostMapping("/salvar")
	public  ResponseEntity<Category> salvar(@RequestBody CategoryForm categoryform){
	  var salvar = service.salvar(categoryform);
	  return ResponseEntity.ok().body(salvar);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> listaCategory(){
		var listar = service.listarTodos();
		return ResponseEntity.ok().body(listar);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> editar(@PathVariable("id") String id, 
			@RequestBody CategoryForm form){
		var update = service.editar(id, form);
		return ResponseEntity.ok().body(update);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> editar(@PathVariable("id") String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	private InforCategoryDTO converter(Category category) {
		InforCategoryDTO inforcategory = new InforCategoryDTO();
			inforcategory.setTilte(category.getTitle());
			inforcategory.setDescription(category.getDescription());
			inforcategory.setOwnerId(category.getOwnerId());
			return inforcategory;
	}
}
