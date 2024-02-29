package com.app.apirest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.apirest.models.PersonModel;
import com.app.apirest.services.PersonService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public Iterable<PersonModel> list () {
        return personService.findAll();
    }

    @GetMapping("{id}")
    public PersonModel get(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public PersonModel create(@RequestBody PersonModel personModel) {
        return personService.create(personModel);
    }

    @PutMapping("{id}")
    public PersonModel update(@PathVariable Integer id, 
    @RequestBody PersonModel form) {
        return personService.update(id,form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        personService.delete(id);
    }
}
