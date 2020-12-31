package br.com.globallabs.springwebmvc.controller;

import java.util.Optional;

import javax.validation.Valid;

import br.com.globallabs.springwebmvc.model.Person;
import br.com.globallabs.springwebmvc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/person")
    public ModelAndView person(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person");


        modelAndView.addObject("allPerson", repository.findAll());

        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "name") final String name) {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person");

        modelAndView.addObject("allPerson", repository.findByNameContainingIgnoreCase(name));

        return modelAndView;
    }


    @GetMapping("/new-person")
    public ModelAndView newPerson(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-person");

        modelAndView.addObject("person", new Person());
        return modelAndView;
    }

    @PostMapping("/person")
    public String createPerson(@Valid @ModelAttribute Person person, BindingResult result, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "new-person";
        }

        repository.save(person);

        redirectAttributes.addFlashAttribute("message", "Person cadatrado com sucesso.");

        return "redirect:person";

    }

    @GetMapping("/person/{id}/delete")
    public String deletePerson(@PathVariable("id") final Long id, RedirectAttributes redirectAttributes) {

        final Optional<Person> person = repository.findById(id);

        repository.delete(person.get());

        redirectAttributes.addFlashAttribute("message", "Person removido com sucesso.");

        return "redirect:/person" ;
    }

    @GetMapping("/person/{id}/update")
    public String updatePerson(@PathVariable("id") final Long id, Model model) {

        final Optional<Person> person = repository.findById(id);

        model.addAttribute("person", person.get());

        return "edit-person";
    }

}
