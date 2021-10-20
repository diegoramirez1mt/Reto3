/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diego.Ramirez
 * Escrito el dia 09.10.2021
 * Mapeo de tabla Message 
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")

public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;//Mario lo quito
    private Integer idMessage;;
    private String messageText;
/* Falta saber como se asocia y como toma el Id message*/
    @ManyToOne    
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages","client","reservations"})//ignore para que no se genere ciclo de un ciclo infinito
    private Game game;
    
    @ManyToOne
    @JoinColumn(name = "clientid")
    @JsonIgnoreProperties({"messages","reservations","client"})// es para que lo ignore//ignore para que no se genere ciclo de un ciclo infinito
    private Client client;
}
