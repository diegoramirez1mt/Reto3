/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.servicio;

import com.reto3.reto3p8g8.entidad.Client;
import com.reto3.reto3p8g8.repositorio.ClientRepositorio;
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
public class ClientServicio {
    @Autowired
    private ClientRepositorio repository;
    /**
    * Operaciones Basicas GET o CREATE
    * @author Diego.Ramirez
    * Creado el 09.10.2021
    * Guardar y crear todos los client
    */
    public Client saveClientAll(Client client){
        return repository.save(client);
    }    
/**
 * Operaciones Basicas POST o READ
 * @author Diego.Ramirez
 * Creado el 09.10.2021
 * Mostrar todos los client
 * 
 */
    public List<Client> getClientAll(){
        return repository.findAll();
    }    

    /**
    * Operaciones Basicas PUT o UPDATE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Actualizar todos los client desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public Client UpdateClient(Client client){
        Client existeClient=repository.findById(client.getIdClient()).orElse(null);
        existeClient.setName(client.getName());
        existeClient.setEmail(client.getEmail());
        existeClient.setPassword(client.getPassword());
        existeClient.setAge(client.getAge());      
        return repository.save(existeClient);
    }
     /**
    * Operaciones Basicas Eliminar o DELETE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Eliminar todos los client desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public String deleteClient(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    
    }
        
}
