package com.example.Desafio_BackEnd_Ifood.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Desafio_BackEnd_Ifood.controller.dto.MessageDTO;
import com.example.Desafio_BackEnd_Ifood.controller.form.CategoryForm;
import com.example.Desafio_BackEnd_Ifood.exception.CategoryNotFoundException;
import com.example.Desafio_BackEnd_Ifood.model.entity.Category;
import com.example.Desafio_BackEnd_Ifood.model.repository.categoryRepository;
import com.example.Desafio_BackEnd_Ifood.model.service.aws.awsSnsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final categoryRepository repository;
	
	private final awsSnsService awsService;
	
	public Category salvar(CategoryForm form) {
		Category category = new Category();
		
		category.setTitle(form.getTitle());
		category.setDescription(form.getDescription());
		category.setOwnerId(form.getOwnerId());
		
		repository.save(category);
		
		MessageDTO messageDTO = new MessageDTO();
	    messageDTO.setOwnerId(category.toString());
	    awsService.publish(messageDTO);
	    		
		return category;
		 
}
	
	public List<Category> listarTodos(){
		return repository.findAll();
	}
	
	
	public Optional<Category> buscarPorId(String id){
		return repository.findById(id);
	}
	
	public Category editar(String id, CategoryForm form) {
		Category category = repository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
		if(!form.getTitle().isEmpty()) category.setTitle(form.getTitle()); 
		if(!form.getDescription().isEmpty()) category.setDescription(form.getDescription());
		repository.save(category);
		
		MessageDTO messageDTO = new MessageDTO();
	    messageDTO.setOwnerId(category.toString());
	    awsService.publish(messageDTO);
	    
		return category;
		
	}
	
	public void  delete(String id) {
		 repository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
		repository.deleteById(id);
		
	}
	
}
