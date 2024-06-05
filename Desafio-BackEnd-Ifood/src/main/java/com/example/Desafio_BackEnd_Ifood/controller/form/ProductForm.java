package com.example.Desafio_BackEnd_Ifood.controller.form;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductForm {
	
	private String title;
	
	private String description;
	
	private Integer price;
	
	private String ownerId;
	
	private String category;
}
