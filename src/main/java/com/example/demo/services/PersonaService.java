package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Persona;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.PersonaRepositorie;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepositorie personaRepositorie;

    public List<Persona> findAll(){
        return personaRepositorie.findAll();
    }

    public Persona createPerson(Persona p){
        return personaRepositorie.save(p);
    }

    public Persona findByID(Long id){
        return personaRepositorie.findById(id)
            .orElseThrow(() -> new NotFoundException("No se encontro ninguna persona con el ID: "+id));
    }

    public Persona updateByID(Long id, Persona p){
        Persona PersonaVieja = personaRepositorie.findById(id).orElseThrow(() -> new NotFoundException("No se encontro nadie con id: "+id));
        PersonaVieja.setApellido(p.getApellido());
        PersonaVieja.setNombre(p.getNombre());
        return personaRepositorie.save(PersonaVieja);
    }
}
