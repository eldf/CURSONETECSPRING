package com.bancolombia.backend.service;

import com.bancolombia.backend.model.ProductEntity;
import lombok.Data;
import org.springframework.http.ResponseEntity;


public interface IProductService {

    ResponseEntity<ProductEntity> create (ProductEntity productEntity);

    ResponseEntity getAll();

    ResponseEntity getById(long id);

    ResponseEntity update(long id, ProductEntity product);

    ResponseEntity getByName(String name);

    ResponseEntity getByStock(int Stock);
}

