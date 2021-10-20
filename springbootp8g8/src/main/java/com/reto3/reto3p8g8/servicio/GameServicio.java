/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.servicio;

import com.reto3.reto3p8g8.entidad.Game;
import com.reto3.reto3p8g8.repositorio.GameRepositorio;
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

public class GameServicio {
    @Autowired
    private GameRepositorio repository;

    /**
    * Operaciones Basicas GET o CREATE
    * @author Diego.Ramirez
    * Creado el 09.10.2021
    * Guardar y crear todos los game
    */
    public Game saveGameAll(Game game){
        return repository.save(game);
    }
    
    
    
    
/**
 * Operaciones Basicas POST o READ
 * @author Diego.Ramirez
 * Creado el 09.10.2021
 * Mostrar todos los game
 * 
 */
    public List<Game> getGameAll(){
        return repository.findAll();
    }
 
    /**
    * Operaciones Basicas PUT o UPDATE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Actualizar todos los game desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public Game UpdateGame(Game game){
        Game existeGame=repository.findById(game.getId()).orElse(null);
        existeGame.setDeveloper(game.getDeveloper());
        existeGame.setYear(game.getYear());
        return repository.save(existeGame);
    }
 
    /**
    * Operaciones Basicas Eliminar o DELETE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Eliminar todos los game desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public String deleteGame(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    
    }


}
