package com.dsgr.springboot.jpa.springdatajpa;

import java.util.List;
import java.util.Optional;

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

		// list();
		findOne();

	}

	public void findOne() {
		// Person person = null;
		// Optional<Person> optionalPerson = personRepository.findById(8L);
		// if(optionalPerson.isPresent()){
		// 	person=optionalPerson.get();
		// }
		// System.out.println(person);

		// personRepository.findById(1L).ifPresent(System.out::println);
		// personRepository.findOne(1L).ifPresent(System.out::println);
		// personRepository.findOneName("Pepe").ifPresent(System.out::println);
		personRepository.findOneLikeName("se").ifPresent(System.out::println);


	}

	public void list() {
		// List<Person> persons = (List<Person>) personRepository.findAll();
		// List<Person> persons = (List<Person>)
		// personRepository.findByProgrammingLanguage("Java");
		// List<Person> persons = (List<Person>)
		// personRepository.buscarByProgrammingLanguage("Python", "Pepe");
		List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguageAndName("Python", "Pepe");
		persons.stream().forEach(p -> System.out.println(p));

		List<Object[]> data = personRepository.obtenerPersonData();
		data.stream().forEach(d -> System.out.println(d[0] + " es experto en " + d[1]));
	}

}
