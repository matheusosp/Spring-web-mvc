package br.com.globaLabs.springwebmvc.Controllers;

import br.com.globaLabs.springwebmvc.Model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonController {

    @GetMapping("/person")
    public ModelAndView person(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Person");
        final Person Luke = new Person("Luke", "Skywalker");
        modelAndView.addObject("allPerson", List.of(Luke));
        return modelAndView;
    }

    @GetMapping("/new-Person")
    public ModelAndView newPerson(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("New Person");

        modelAndView.addObject("person", new Person());
        return modelAndView;
    }
}
