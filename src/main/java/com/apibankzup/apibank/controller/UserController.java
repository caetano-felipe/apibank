package com.apibankzup.apibank.controller;

import com.apibankzup.apibank.model.UserModel;
import com.apibankzup.apibank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getByIdUser(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserModel>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
    }

    @PostMapping
    public ResponseEntity<UserModel> postUser(@RequestBody UserModel user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @PutMapping
    public ResponseEntity<UserModel> putUser(@RequestBody UserModel user) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        repository.deleteById(id);
    }
}
