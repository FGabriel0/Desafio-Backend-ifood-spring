package com.example.Desafio_BackEnd_Ifood.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Desafio_BackEnd_Ifood.controller.dto.MessageDTO;
import com.example.Desafio_BackEnd_Ifood.controller.form.ProductForm;
import com.example.Desafio_BackEnd_Ifood.exception.CategoryNotFoundException;
import com.example.Desafio_BackEnd_Ifood.model.entity.Category;
import com.example.Desafio_BackEnd_Ifood.model.entity.Product;
import com.example.Desafio_BackEnd_Ifood.model.repository.productRepository;
import com.example.Desafio_BackEnd_Ifood.model.service.aws.awsSnsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final productRepository repository;
	
	private final  CategoryService serviceCategory;
	
	private final awsSnsService awsService;
	
	public Product salvar(ProductForm form) {
		String idCategory = form.getCategory();
		Category category = serviceCategory.buscarPorId(idCategory)
			.orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
			
		Product produto = new Product();
		
		produto.setTitle(form.getTitle());
		produto.setDescription(form.getDescription());
		produto.setOwnerId(form.getOwnerId());
		produto.setCategory(category);
		produto.setPrice(form.getPrice());
		
		repository.save(produto);
		
		MessageDTO messageDTO = new MessageDTO();
	    messageDTO.setOwnerId(produto.toString());
	    awsService.publish(messageDTO);
	        
		return produto;
		 
}
	
	public List<Product> listarTodos(){
		return repository.findAll();
	}
	
	
	
	public Product editar(String id, ProductForm form) {
		String idCategory = form.getCategory();
		Category category = serviceCategory.buscarPorId(idCategory)
			.orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
		
		Product produto = repository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Produto não encontrado"));
		
		if(!form.getTitle().isEmpty()) produto.setTitle(form.getTitle()); 
		if(!form.getDescription().isEmpty()) produto.setDescription(form.getDescription());
		if(!form.getCategory().isEmpty()) produto.setCategory(category);
        if(!(form.getPrice() == null)) produto.setPrice(form.getPrice());
		repository.save(produto);
		
		MessageDTO messageDTO = new MessageDTO();
	    messageDTO.setOwnerId(produto.toString());
	    awsService.publish(messageDTO);
	    
		return produto;
		
	}
	
	public void  delete(String id) {
		 repository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
		repository.deleteById(id);
		
	}
	
}