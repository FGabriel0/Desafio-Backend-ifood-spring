package com.example.Desafio_BackEnd_Ifood.controller.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryForm {

	private String title;
	private String description;
	private String ownerId;
}
