package br.com.globallabs.springwebmvc.repository;

import java.util.List;

import br.com.globallabs.springwebmvc.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByNameContainingIgnoreCase(final String name);

}
