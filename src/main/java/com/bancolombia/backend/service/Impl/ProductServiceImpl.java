package com.bancolombia.backend.service.Impl;

import com.bancolombia.backend.model.ProductEntity;
import com.bancolombia.backend.repository.IProductRepository;
import com.bancolombia.backend.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    @Override
    public ResponseEntity create(ProductEntity productEntity) {
        /*var product = this.productRepository.save(productEntity);*/
        ProductEntity product = this.productRepository.save(productEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @Override
    public ResponseEntity getAll() {
        var productList = this.productRepository.findAll();
        return ResponseEntity.ok(productList);
    }

    @Override
    public ResponseEntity getById(long id) {
        var product = this.productRepository.findById(id);
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity update(long id, ProductEntity product) {
        var productEntity = this.productRepository.findById(id);
        if(productEntity.isPresent()){
            ProductEntity newProduct =productEntity.get();
            newProduct.setName(product.getName());
            newProduct.setStock(product.getStock());
            var updateProduct = this.productRepository.save(newProduct);

            return ResponseEntity.ok(updateProduct);
        }
        return ResponseEntity
                .ok("No existe el producto a Actualizar");
    }

    @Override
    public ResponseEntity getByName(String name) {
        var productEntity = this.productRepository.findByName(name);
        return ResponseEntity.ok(productEntity);
    }

    /*hacer la invocacion de estos servicios en el controller
     * clase */

}