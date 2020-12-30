package com.spring.web.controller;

import javax.validation.Valid;

import com.spring.web.model.Person;
import com.spring.web.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository repository;
    
    @GetMapping("/person")
    public ModelAndView jedi() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person");
        modelAndView.addObject("allPerson", repository.getAll());

        return modelAndView;
    }

    @GetMapping("/new-person")
    public String createJedi(Model model) {

        model.addAttribute("person", new Person());
        
        return "new-person";
    }

    @PostMapping("/person")
    public String createJedi(@Valid @ModelAttribute Person person, BindingResult result, RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "new-person";
        }
        repository.add(person);
        redirect.addFlashAttribute("message", "Person successfully created.");

        return "redirect:person";
    }

}
