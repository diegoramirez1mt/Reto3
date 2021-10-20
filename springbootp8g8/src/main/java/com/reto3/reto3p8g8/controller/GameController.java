/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.controller;

import com.reto3.reto3p8g8.entidad.Game;
import com.reto3.reto3p8g8.servicio.GameServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/Game")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class GameController {
    @Autowired
    private GameServicio service;
    
    @GetMapping("/all")
    public List<Game> findAllGame(){
        return service.getGameAll();         
    }
/* Profe Jhony    
    @GetMapping("/(id)")
    public Optional<Game> getGame(@PathVariable("id") int gameId){
        return service.getGame(gameId);         
    } */
    
    
    @PostMapping("/save")
    
    public ResponseEntity addGame(@RequestBody Game game){
        service.saveGameAll(game);
        return ResponseEntity.status(201).build();
    
    }
    
    @PutMapping("/update")
    public ResponseEntity updateGame(@RequestBody Game game){
        service.UpdateGame(game);
        return ResponseEntity.status(201).build();
    }    
    
    @DeleteMapping("/delete")    
    public ResponseEntity deleteGame(@RequestBody Game game){
        service.deleteGame(game.getId());
        return ResponseEntity.status(204).build();
    }
}
