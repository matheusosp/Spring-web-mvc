package br.com.globallabs.springwebmvc.rest;

import java.util.List;

import javax.validation.Valid;

import br.com.globallabs.springwebmvc.model.Person;
import br.com.globallabs.springwebmvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResource {

    @Autowired
    private PersonService service;

    @GetMapping("/api/person")
    public List<Person> getAllPerson() {

       return service.findAll();

    }

    @GetMapping("/api/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        final Person person = service.findById(id);

        return ResponseEntity.ok(person);
    }

    @PostMapping("/api/person")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@Valid @RequestBody Person person){

        return service.save(person);
    }
    
    @PutMapping("/api/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @Valid @RequestBody Person dto) {

        final Person person = service.update(id, dto);

        return ResponseEntity.ok(person);

    }

    @DeleteMapping("/api/person/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
