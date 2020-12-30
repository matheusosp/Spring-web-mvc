package br.com.globaLabs.springwebmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("/person")
    public String person(){
        return "Person";
    }

}
