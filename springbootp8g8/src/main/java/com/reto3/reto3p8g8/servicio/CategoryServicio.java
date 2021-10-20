/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.servicio;

import com.reto3.reto3p8g8.entidad.Category;
import com.reto3.reto3p8g8.repositorio.CategoryRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego.Ramirez
 * Creado el 09.10.2021
 * Operaciones básicas, intermediario entre controlador y el repositorio
 * 
 */
@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio repository;
    /**
    * Operaciones Basicas GET o CREATE
    * @author Diego.Ramirez
    * Creado el 09.10.2021
    * Guardar y crear todos los category
    */
    public Category saveCategoryAll(Category category){
        
        return repository.save(category);
    }    
/**
 * Operaciones Basicas POST o READ
 * @author Diego.Ramirez
 * Creado el 09.10.2021
 * Mostrar todos los category
 * 
 */
    public List<Category> getCategoryAll(){
        return repository.findAll();
    }    

    /**
    * Operaciones Basicas PUT o UPDATE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Actualizar todos los category desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public Category UpdateCategory(Category category){
        Category existeCategory=repository.findById(category.getId()).orElse(null);
        existeCategory.setDescription(category.getDescription());
        existeCategory.setName(category.getName());
        /*existeCategory.setGame(category.getGame());*/
        return repository.save(existeCategory);
    }
     /**
    * Operaciones Basicas Eliminar o DELETE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Eliminar todos los category desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public String deleteCategory(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    
    }
        
}
