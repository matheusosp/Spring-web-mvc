package br.com.globaLabs.springwebmvc.personRepository;

import br.com.globaLabs.springwebmvc.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class personRepository {

    private List<Person> person;

    public personRepository() {
        person = new ArrayList<>();
        person.add(new Person("Luke","Skywalker"));
    }

    public List<Person> getAllPerson(){
         return this.person;
    }

    public void add(Person person) {
        this.person.add(person);
    }
}
