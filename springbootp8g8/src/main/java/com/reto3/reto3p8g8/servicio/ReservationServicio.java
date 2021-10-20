/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.servicio;

import com.reto3.reto3p8g8.entidad.Reservation;
import com.reto3.reto3p8g8.repositorio.ReservationRepositorio;
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

public class ReservationServicio {
    @Autowired
    private ReservationRepositorio repository;

    /**
    * Operaciones Basicas GET o CREATE
    * @author Diego.Ramirez
    * Creado el 09.10.2021
    * Guardar y crear todos los reservation
    */
    public Reservation saveReservationAll(Reservation reservation){
        return repository.save(reservation);
    }
    
    
    
    
/**
 * Operaciones Basicas POST o READ
 * @author Diego.Ramirez
 * Creado el 09.10.2021
 * Mostrar todos los reservation
 * 
 */
    public List<Reservation> getReservationAll(){
        return repository.findAll();
    }
 
    /**
    * Operaciones Basicas PUT o UPDATE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Actualizar todos los reservation desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public Reservation UpdateReservation(Reservation reservation){
        Reservation existeReservation=repository.findById(reservation.getIdReservation()).orElse(null);
        existeReservation.setStartDate(reservation.getStartDate());
        existeReservation.setDevolutionDate(reservation.getDevolutionDate());
        return repository.save(existeReservation);
    
    }
 
    /**
    * Operaciones Basicas Eliminar o DELETE
    * @author Diego.Ramirez
    * Creado el 10.10.2021
    * Eliminar todos los reservation desde al JSON, si encuentra con finById, sino que coloque null
    * si existe el elemento lo lleva a cambiarlo, ajustarlo o repisarlo
    */
    public String deleteReservation(int id){
        repository.deleteById(id);
        return "Item Removido"+id;
    
    }


}
