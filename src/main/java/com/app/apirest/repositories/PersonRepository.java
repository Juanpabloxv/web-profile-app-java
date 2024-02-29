package com.app.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.apirest.models.PersonModel;

@Repository
public interface PersonRepository extends  CrudRepository <PersonModel, Integer>{
}
