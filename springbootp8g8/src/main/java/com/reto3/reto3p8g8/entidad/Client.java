/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diego.Ramirez
 * Escrito el dia 09.10.2021
 * Mapeo de tabla Client 
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")

public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="client")
    @JsonIgnoreProperties("client")//ignore para que no se genere ciclo de un ciclo infinito
    private List<Message> messages;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="client")
    @JsonIgnoreProperties("client")//ignore para que no se genere ciclo de un ciclo infinito
    private List<Reservation> reservations;   
}    

