package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import com.spring.web.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private List<Person> person;

    public PersonRepository() {
        person = new ArrayList<>();
        person.add(new Person("Luke", "Skywalker"));
        person.add(new Person("Obi-Wan", "Kenobi"));
        person.add(new Person("Qui-Gon", "Jinn"));
    }

    public List<Person> getAll() {
        return person;
    }

    public void add(final Person person) {
       this.person.add(person);
    }
}
