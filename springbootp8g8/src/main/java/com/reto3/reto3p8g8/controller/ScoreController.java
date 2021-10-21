/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.controller;

import com.reto3.reto3p8g8.entidad.Score;
import com.reto3.reto3p8g8.servicio.ScoreServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/ScoreErr")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ScoreController {
    @Autowired
    private ScoreServicio service;
    
    @GetMapping("/all")
    public List<Score> findAllScore(){
        return service.getScoreAll();
                
    }
    
    @PostMapping("/save")
    public ResponseEntity addScore(@RequestBody Score scoreErr){
        service.saveScoreAll(scoreErr);
        return ResponseEntity.status(201).build();
    
    }
    /* PENDIENTE
        @PutMapping("/update")
        public ResponseEntity updateScore(@RequestBody Err score){
            service.UpdateScore(score);
            return ResponseEntity.status(201).build();
        }    
    
        @DeleteMapping("/delete")    
            public ResponseEntity deleteScore(@RequestBody Err score){
            service.deleteScore(score.getId());
            return ResponseEntity.status(204).build();
    } */
}
