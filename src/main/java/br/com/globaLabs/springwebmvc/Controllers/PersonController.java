package br.com.globaLabs.springwebmvc.Controllers;

import br.com.globaLabs.springwebmvc.Model.Person;
import br.com.globaLabs.springwebmvc.personRepository.personRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class PersonController {

    @Autowired
    private personRepository repository;

    @GetMapping("/person")
    public ModelAndView person(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person");
        modelAndView.addObject("allPerson", repository.getAllPerson());

        return modelAndView;
    }

    @GetMapping("/new-Person")
    public String newPerson(Model model){

        model.addAttribute("person",new Person());
        return "new-person";
    }

    @PostMapping("/person")
    public String createPerson(@Valid @ModelAttribute Person person, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "new-person";
        }
        repository.add(person);

        redirect.addFlashAttribute("message", "person registered");
        return "redirect:person";
    }
}
