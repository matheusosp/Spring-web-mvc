package br.com.globallabs.springwebmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name="id_person")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 10, message = "Nome deve conter entre 3 e 10 caracteres")
    @NotBlank(message = "Nome não pode estar em branco")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Sobrenome não pode estar em branco")
    @Column(name = "last_name")
    private String lastName;

    public Person(final String name, final String lastname) {
        this.name = name;
        this.lastName = lastname;
    }

    public Person() {
    }

    public String getName () {
        return name;
    }

    public void setName (final String name) {
        this.name = name;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (final String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
