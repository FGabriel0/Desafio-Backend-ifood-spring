package com.example.Desafio_BackEnd_Ifood.model.entity;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product {
	
	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private Integer price;
	
	private String ownerId;
	
	private Category category;
	
	
	 @Override
	    public String toString(){
	        JSONObject json = new JSONObject();
	        json.put("id", id);
	        json.put("title", title);
	        json.put("description", description);
	        json.put("ownerId", ownerId);
	        json.put("price", price);
	        json.put("category", category);
	        json.put("type", "produto");

	        return json.toString();
	    }

	    public String deleteToString(){
	        JSONObject json = new JSONObject();
	        json.put("id", this.id);
	        json.put("ownerId", this.ownerId);
	        json.put("type", "delete-produto");

	        return json.toString();
	    }
}
