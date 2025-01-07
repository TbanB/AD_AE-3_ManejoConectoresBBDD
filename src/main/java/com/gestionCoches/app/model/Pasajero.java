package com.gestionCoches.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pasajero {
    private int id;
    private String nombre;
    private double peso;
    private int edad, cocheId;

     public Pasajero(String nombre, double peso, int edad, int cocheId) {
         this.nombre = nombre;
         this.peso = peso;
         this.edad = edad;
         this.cocheId = cocheId;
     }
}
