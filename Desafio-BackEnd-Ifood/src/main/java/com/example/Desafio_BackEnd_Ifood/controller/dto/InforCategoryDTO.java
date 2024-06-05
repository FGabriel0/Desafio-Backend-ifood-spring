package com.example.Desafio_BackEnd_Ifood.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InforCategoryDTO {

	private String tilte;
	private String description;
	private String ownerId;
}
