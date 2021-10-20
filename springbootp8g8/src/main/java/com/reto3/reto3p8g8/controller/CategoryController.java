/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.controller;

import com.reto3.reto3p8g8.entidad.Category;
import com.reto3.reto3p8g8.servicio.CategoryServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diego.Ramirez
 * Creado el 10.10.2021
 * Capa que sirve para crear la api
 * Cuando se despliega el embebido se ejecuta
 */
@RestController 
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class CategoryController {
    @Autowired
    private CategoryServicio service;
    // Se ingresan los controladores
    // Metodo get
    @GetMapping("/all")
    public List<Category> findAllCategory(){
        return service.getCategoryAll();
                
    }
    // Metodo post
    @PostMapping("/save")
    public ResponseEntity addCategory(@RequestBody Category category){
        service.saveCategoryAll(category);
        return ResponseEntity.status(201).build();
    
    }
    
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.UpdateCategory(category);
        return ResponseEntity.status(201).build();
    }    
    
    @DeleteMapping("/delete")    
        public ResponseEntity deleteCategory(@RequestBody Category category){
        service.deleteCategory(category.getId());
        return ResponseEntity.status(204).build();
    }
    
}
