package com.meteora.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProductController {
    
    @Autowired
    private ProductRepository repository;

    @GetMapping("/listar")
    public List <ProductModel> list() {
        return repository.findAll();
    }

    @PostMapping("/cadastrar")
    public void register(@RequestBody @Valid ProductRegisterData data){
        repository.save(new ProductModel(data));
    }

}
