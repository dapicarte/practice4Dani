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
}
