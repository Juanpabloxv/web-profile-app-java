package com.app.apirest.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.apirest.models.PersonModel;
import com.app.apirest.repositories.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public Iterable<PersonModel> findAll() {
        return personRepository.findAll();
    }

    public PersonModel findById(Integer id) {
        return personRepository
        .findById(id)
        .orElse(null);
    }

    public PersonModel create(PersonModel personModel) {
        return personRepository.save(personModel);
    }

    public PersonModel update(Integer id, PersonModel form) {
        PersonModel personFormDb = findById(id);

        personFormDb.setFirsName(form.getFirsName());
        personFormDb.setLastName(form.getLastName());
        personFormDb.setEmail(form.getEmail());
        personFormDb.setNumeroTelefono(form.getNumeroTelefono());
        personFormDb.setCiudad(form.getCiudad());
        personFormDb.setPais(form.getPais());

        return personRepository.save(personFormDb);
    }

    public void delete(@PathVariable Integer id) {
        PersonModel personFormDb = personRepository
        .findById(id)
        .orElse(null);
        personRepository.delete(personFormDb);
    }

}
