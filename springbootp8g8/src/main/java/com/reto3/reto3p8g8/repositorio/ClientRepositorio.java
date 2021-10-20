/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto3.reto3p8g8.repositorio;

import com.reto3.reto3p8g8.entidad.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Diego.Ramirez
 * Realizado el dia 09.10.2021
 * Repositorio
 * Sirve para las operaciones basicas del CRUD
 */
public interface ClientRepositorio extends JpaRepository<Client,Integer> {
    
}
