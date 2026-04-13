package com.caso4.practice4Dani.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caso4.practice4Dani.model.Persona;
import com.caso4.practice4Dani.service.PersonaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<?> getPersonas(){
        List<Persona> lista = personaService.readAll();
        if(lista.isEmpty()){
            return ResponseEntity
            .status(404)
            .body("No hay personas ingresadas");
        }
        return ResponseEntity.ok(lista);        
    }

    @PostMapping
    public ResponseEntity<?> postPersona(@Valid @RequestBody Persona persona){
        Persona p = personaService.create(persona);
        if(p!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("La persona se ha creado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La persona no se ha creado");
    }

    @DeleteMapping("{id}")
    public String deletePersona(@PathVariable int id){
        return personaService.delete(id);
    }
}
