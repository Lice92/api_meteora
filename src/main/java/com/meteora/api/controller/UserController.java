package com.meteora.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping("/listar")
    public List<UserModel> list() {
        return repository.findAll();
    }

    @Transactional
    @PostMapping("/cadastrar")
    public void register(@RequestBody @Valid RegisterUserData data) {
        repository.save(new UserModel(data));
    }

    @Transactional
    @PutMapping
    public void update(@RequestBody UpdateUserData data) {
        UserModel user = repository.getReferenceById(data.id());
        user.updateInfo(data);
    }
    
    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
