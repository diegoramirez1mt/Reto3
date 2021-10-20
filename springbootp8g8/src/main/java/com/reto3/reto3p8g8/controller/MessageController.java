/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.controller;

import com.reto3.reto3p8g8.entidad.Message;
import com.reto3.reto3p8g8.servicio.MessageServicio;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class MessageController {
    @Autowired
    private MessageServicio service;
    
    @GetMapping("/all")
    public List<Message> findAllMessage(){
        return service.getMessageAll();
                
    }
    
    @PostMapping("/save")
    public ResponseEntity addMessage(@RequestBody Message message){
        service.saveMessageAll(message);
        return ResponseEntity.status(201).build();
    
    }
    
    @PutMapping("/update")
    public ResponseEntity updateMessage(@RequestBody Message message){
        service.UpdateMessage(message);
        return ResponseEntity.status(201).build();
    }    
    
    @DeleteMapping("/delete")    
    public ResponseEntity deleteMessage(@RequestBody Message message){
        service.deleteMessage(message.getIdMessage());
        return ResponseEntity.status(204).build();
    }
}
