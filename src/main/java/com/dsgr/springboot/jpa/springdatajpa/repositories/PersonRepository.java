package com.dsgr.springboot.jpa.springdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dsgr.springboot.jpa.springdatajpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {


}
