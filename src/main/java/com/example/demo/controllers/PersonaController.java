package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Persona;
import com.example.demo.services.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    PersonaService personaService;


    @GetMapping("/personas")
    public List<Persona> metodo() {
        return personaService.findAll();
    }

    @PostMapping("/persona")
    public Persona createPerson(@RequestBody Persona persona) {
        return personaService.createPerson(persona);
    }
    
    @GetMapping("/persona/{id}")
    public Persona getMethodName(@PathVariable Long id) {
        return personaService.findByID(id);
    }

    @PatchMapping("/persona/{id}")
    public Persona updatePerson(@RequestBody Persona persona, @PathVariable Long id){
        return personaService.updateByID(id, persona);
    }
    
    
}
