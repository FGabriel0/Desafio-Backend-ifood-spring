package com.example.Desafio_BackEnd_Ifood.model.entity;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "category")
public class Category {

	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private String ownerId;
	
	
	 @Override
	    public String toString(){
	        JSONObject json = new JSONObject();
	        json.put("id", id);
	        json.put("title", title);
	        json.put("description", description);
	        json.put("ownerId", ownerId);
	        json.put("type", "categoria");

	        return json.toString();
	    }

	    public String deleteToString(){
	        JSONObject json = new JSONObject();
	        json.put("id", this.id);
	        json.put("ownerId", this.ownerId);
	        json.put("type", "delete-categoria");

	        return json.toString();
	    }

	
}
