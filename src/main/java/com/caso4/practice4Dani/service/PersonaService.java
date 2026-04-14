package com.caso4.practice4Dani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caso4.practice4Dani.model.Persona;
import com.caso4.practice4Dani.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona create(Persona persona){
        return personaRepository.agregar(persona);
    }

    public List<Persona> readAll(){
        return personaRepository.listar();
    }

    public String delete(int id){
        Persona p = personaRepository.buscarId(id);
        if(p!=null){
            if(personaRepository.eliminar(id)){
            return "La persona "+p.getNombre()+" se ha eliminado";
            }
        }
        return "La persona NO se ha eliminado";
    }

    public Persona search(int id){
        return personaRepository.buscarId(id);
    }
    public void seed(){
        personaRepository.seed();
    }
    /** public TituloDTO tituloDTO(Persona persona){
        personaRepository.agregar(persona);
        String estado;
        if(persona.isTitulo()){
            estado = "Persona con titulo";
        } else {
            estado = "Persona sin titulo";
        }
        return new TituloDTO(persona.getNombre(),persona.getApellido(), estado);
    } **/
}
