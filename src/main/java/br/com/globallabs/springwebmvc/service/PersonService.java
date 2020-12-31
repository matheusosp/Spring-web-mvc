package br.com.globallabs.springwebmvc.service;

import java.util.List;
import java.util.Optional;

import br.com.globallabs.springwebmvc.excepiton.PersonNotFoundException;
import br.com.globallabs.springwebmvc.model.Person;
import br.com.globallabs.springwebmvc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {

         return repository.findAll();
    }

    public Person findById(final Long id) {
        final Optional<Person> person = repository.findById(id);

        if(person.isPresent()){
            return person.get();
        }else{
            throw new PersonNotFoundException();
        }
    }

    public Person save(final Person person) {
        return repository.save(person);
    }

    public Person update(final Long id, final Person dto) {
        final Optional<Person> personEntity = repository.findById(id);
        final Person person;

        if (personEntity.isPresent()) {
            person = personEntity.get();
        }else {
            throw new PersonNotFoundException();
        }

        person.setName(dto.getName());
        person.setLastName(dto.getLastName());

        return repository.save(person);
    }

    public void delete(final Long id) {
        final Person person = findById(id);

        repository.delete(person);
    }
}
