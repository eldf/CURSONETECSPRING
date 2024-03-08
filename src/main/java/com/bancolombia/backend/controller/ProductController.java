package com.bancolombia.backend.controller;


import com.bancolombia.backend.backend.model.ProductEntity;
import com.bancolombia.backend.backend.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final IProductService productService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductEntity productEntity){
        return this.productService.create(productEntity);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return this.productService.getAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id,@RequestBody ProductEntity productEntity){
        return this.productService.update(id,productEntity);
    }


}