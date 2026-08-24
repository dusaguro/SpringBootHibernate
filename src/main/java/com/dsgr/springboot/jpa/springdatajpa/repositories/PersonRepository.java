package com.dsgr.springboot.jpa.springdatajpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dsgr.springboot.jpa.springdatajpa.dto.PersonDto;
import com.dsgr.springboot.jpa.springdatajpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.id between 2 and 5 order by p.programmingLanguage")
    List<Person> findAllBetweenIdsOrderByLanguages();

    @Query("select p from Person p where p.name between 'J' and 'P' order by p.name")
    List<Person> findAllBetweenNamesOrderByNames();

    @Query("select p from Person p where p.name between 'J' and 'P' order by p.name desc")
    List<Person> findAllBetweenNamesOrderByNamesDesc();

    @Query("select p from Person p where p.name between 'J' and 'P' order by p.name desc, p.lastname desc")
    List<Person> findAllBetweenNamesOrderByFullNamesDesc();

    List<Person> findByIdBetween(Long id1, Long id2);

    List<Person> findByNameBetween(String name1, String name2);

    List<Person> findByNameBetweenOrderByNameDesc(String name1, String name2);

    @Query("select p from Person p where p.id between 2 and 5")
    List<Person> findAllBetweenIds();

    @Query("select p from Person p where p.name between 'J' and 'P'")
    List<Person> findAllBetweenNames();

    @Query("select concat(p.name, ' ', p.lastname) as fullname from Person p")
    List<String> findAllFullNameConcat();

    @Query("select p.name || ' ' || p.lastname as fullname from Person p")
    List<String> findAllFullNameConcatAlt();

    @Query("select upper(p.name || ' ' || p.lastname) as fullname from Person p")
    List<String> findAllFullNameConcatAltUpper();

    @Query("select lower(concat(p.name, ' ', p.lastname)) as fullname from Person p")
    List<String> findAllFullNameConcatAltLower();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select distinct(p.name) from Person p")
    List<String> findAllNamesDistinct();

    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> findAllProgrammingLanguageDistinct();

    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    Long findAllProgrammingLanguageDistinctCount();

    @Query("select new com.dsgr.springboot.jpa.springdatajpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllPersonDto();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllObjectPersonPersonalized();

    @Query("select p.name from Person p where p.id = ?1")
    String getNameById(Long id);

    @Query("select p.id from Person p where p.id = ?1")
    Long getIdById(Long id);

    @Query("select concat(p.name, ' ', p.lastname) as fullname from Person p where p.id = ?1")
    String getFullNameById(Long id);

    @Query("select p from Person p where p.id = ?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name = ?1")
    Optional<Person> findOneName(String name);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByNameContaining(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage = ?1 and p.name = ?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p,  p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonDataList();

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id = ?1")
    Optional<Object> obtenerPersonDataById(Long id);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p.name, p.programmingLanguage from Person p where name=?1")
    List<Object[]> obtenerPersonData(String name);

    @Query("select p.name, p.programmingLanguage from Person p where name=?1 and lastname=?2")
    List<Object[]> obtenerPersonData(String name, String lastname);

}
