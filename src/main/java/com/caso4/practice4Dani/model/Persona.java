package com.caso4.practice4Dani.model;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {
    private static final AtomicInteger contador = new AtomicInteger();
    private int id;
    @NotNull(message = "el nombre no puede ser vacio")
    @Size(min = 4, max = 15, message = "caracteres entre 4 y 15")
    private String nombre;

    @NotNull(message = "el apellido no puede ser vacio")
    @Size(min = 4, max = 15, message = "caracteres entre 4 y 15")
    private String apellido;
    
    @Min(value = 1, message = "La edad no puede ser menor a 1")
    @Max(value = 90, message = "La edad no puede ser mayor a 90")
    private int edad;

    private boolean titulo;

    public Persona(String nombre, String apellido, int edad, boolean titulo){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.titulo=titulo;
    }
}
