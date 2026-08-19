package com.dsgr.springboot.jpa.springdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dsgr.springboot.jpa.springdatajpa.entities.Person;
import com.dsgr.springboot.jpa.springdatajpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Person> persons = (List<Person>) personRepository.findAll();
		persons.stream().forEach(p -> System.out.println(p));

	}

}
