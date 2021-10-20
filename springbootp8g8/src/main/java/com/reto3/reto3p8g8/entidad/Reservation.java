/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3p8g8.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diego.Ramirez
 * Escrito el dia 09.10.2021
 * Mapeo de tabla Reservation 
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")

public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;
    private Integer idReservation;
    private Date startDate; // fecha y horas
    private Date devolutionDate;
    private String status="created";// Lo adiciono Mario
    
/* Falta saber como se asocia y como toma el Id message*/    
    @ManyToOne    
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")// Lo adiciono Mario
    private Game game;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    //@JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservations","messages"})//ignore para que no se genere ciclo de un ciclo infinito
    private Client client;
 
    //@OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservation")  
    //@JsonIgnoreProperties("reservation")//ignore para que no se genere ciclo de un ciclo infinito
    //@JoinColumn(name = "category_id")
    //private Category category; 
    private Score score;
    // se puede dejar como para que de el null
    //private String score;
}
