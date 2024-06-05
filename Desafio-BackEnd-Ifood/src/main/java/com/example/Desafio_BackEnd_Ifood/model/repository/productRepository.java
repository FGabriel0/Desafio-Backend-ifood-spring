package com.example.Desafio_BackEnd_Ifood.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Desafio_BackEnd_Ifood.model.entity.Product;

@Repository
public interface productRepository extends MongoRepository<Product, String> {

}
