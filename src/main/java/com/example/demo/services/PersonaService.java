package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Persona;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll(){
        return personaRepository.findAll();
    }

    public Persona createPerson(Persona p){
        return personaRepository.save(p);
    }

    public Persona findByID(Long id){
        return personaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("No se encontro ninguna persona con el ID: "+id));
    }

    public Persona updateByID(Long id, Persona p){
        Persona PersonaVieja = personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro nadie con id: "+id));
        PersonaVieja.setApellido(p.getApellido());
        PersonaVieja.setNombre(p.getNombre());
        return personaRepository.save(PersonaVieja);
    }
}
