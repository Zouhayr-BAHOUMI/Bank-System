package Wafacash.controller;

import Wafacash.model.Compte;
import Wafacash.model.User;
import Wafacash.service.CompteService;
import Wafacash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @PostMapping("/add")
    public String ajouterCompte(@RequestBody Compte compte){

        compteService.addCompte(compte);
        return "added successfully";
    }
}
