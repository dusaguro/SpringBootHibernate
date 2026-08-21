package com.dsgr.springboot.jpa.springdatajpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		// findOne();
		// create();
		// update();
		// delete();
	}

	@Transactional
	public void delete2() {
		personRepository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id para eliminar el registro");
		Long id = scanner.nextLong();
		
		personRepository.findById(id).ifPresentOrElse(personRepository::delete, () -> System.out.println("No existe el registro con ese id: " + id));

		// Optional<Person> optionalPerson = personRepository.findById(id);
		// if(optionalPerson.isPresent()){
		// Person person = optionalPerson.get();
		// personRepository.delete(person);
		// }else {
		// System.out.println("No existe el registro con id: " + id);
		// }

		personRepository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional
	public void delete() {

		personRepository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id para eliminar el registro");
		Long id = scanner.nextLong();
		personRepository.deleteById(id);
		personRepository.findAll().forEach(System.out::println);
		scanner.close();

	}

	@Transactional
	public void update() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el id a actualizar:");
		Long id = scanner.nextLong();

		Optional<Person> person = personRepository.findById(id);

		person.ifPresentOrElse(p -> {
			System.out.println(p);
			System.out.println("Ingrese el nuevo lenguaje:");
			String programmingLanguage = scanner.next();
			p.setProgrammingLanguage(programmingLanguage);
			Person personDB = personRepository.save(p);
			System.out.println(personDB);
		}, () -> System.out.println("No existe registro con el id: " + id));

		scanner.close();

	}

	@Transactional
	public void create() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Name:");
		String name = sc.next();

		System.out.println("LastName:");
		String lastname = sc.next();

		System.out.println("ProgrammingLanguage:");
		String programmingLanguage = sc.next();

		sc.close();

		Person person = new Person(null, name, lastname, programmingLanguage);
		Person personNew = personRepository.save(person);
		personRepository.findById(personNew.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne() {
		// Person person = null;
		// Optional<Person> optionalPerson = personRepository.findById(8L);
		// if(optionalPerson.isPresent()){
		// person=optionalPerson.get();
		// }
		// System.out.println(person);

		// personRepository.findById(1L).ifPresent(System.out::println);
		// personRepository.findOne(1L).ifPresent(System.out::println);
		// personRepository.findOneName("Pepe").ifPresent(System.out::println);
		personRepository.findOneLikeName("se").ifPresent(System.out::println);

	}

	@Transactional(readOnly = true)
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
