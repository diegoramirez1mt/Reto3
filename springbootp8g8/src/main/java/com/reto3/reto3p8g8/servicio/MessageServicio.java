/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.servicio;

import com.reto3.reto3p8g8.entidad.Message;
import com.reto3.reto3p8g8.repositorio.MessageRepositorio;
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

public class MessageServicio {
    @Autowired
    private MessageRepositorio repository;

    /**
    * Operaciones Basicas GET o CREATE
    * @author Diego.Ramirez
    * Creado el 09.10.2021
    * Guardar y crear todos los message
    */
    public Message saveMessageAll(Message message){
        return repository.save(message);
    }
    
    
    
    
/**
 * Operaciones Basicas POST o READ
 * @author Diego.Ramirez
 * Creado el 09.10.2021
 * Mostrar todos los message
 * 
 */
    public List<Message> getMessageAll(){
        return repository.findAll();
    }
 
    /**
    * Operaciones Basicas PUT o UPDATE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Actualizar todos los message desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public Message UpdateMessage(Message message){
        Message existeMessage=repository.findById(message.getIdMessage()).orElse(null);
        //existeMessage.setIdMessage(message.getIdMessage());//Mario lo inactivo
        existeMessage.setMessageText(message.getMessageText());
        return repository.save(existeMessage);
    
    }
 
    /**
    * Operaciones Basicas Eliminar o DELETE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Eliminar todos los message desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public String deleteMessage(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    
    }


}
