package com.caso4.practice4Dani.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.caso4.practice4Dani.model.Persona;
@Repository
public class PersonaRepository {
    private List<Persona> listaPersonas=new ArrayList<>();

    public Persona agregar(Persona persona){
        listaPersonas.add(persona);
        return persona;
    }

    public List<Persona> listar(){
        return listaPersonas;
    }

    public boolean eliminar(int id){
        return listaPersonas.removeIf(b -> b.getId()==id);
    }

    public Persona buscarId(int id){
        for(Persona p : listaPersonas){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
    public void seed(){
        listaPersonas.add(new Persona("Juan", "Pérez", 25, true));
        listaPersonas.add(new Persona("María", "González", 30, false));
        listaPersonas.add(new Persona("Carlos", "Rojas", 22, true));
        listaPersonas.add(new Persona("Ana", "Muñoz", 28, false));
        listaPersonas.add(new Persona("Luis", "Soto", 35, true));
        listaPersonas.add(new Persona("Camila", "Torres", 27, true));
        listaPersonas.add(new Persona("Diego", "Fernández", 40, false));
        listaPersonas.add(new Persona("Valentina", "Castillo", 23, true));
        listaPersonas.add(new Persona("Javier", "Morales", 31, false));
        listaPersonas.add(new Persona("Fernanda", "Vargas", 29, true));
    }
}
