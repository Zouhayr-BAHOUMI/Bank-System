package Wafacash.controller;

import Wafacash.model.Compte;
import Wafacash.model.User;
import Wafacash.service.CompteService;
import Wafacash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/{idCompte}/solde")
    public ResponseEntity<Double> consulterSolde(@PathVariable int idCompte) throws Exception {
        double solde = compteService.getSolde(idCompte);
        return ResponseEntity.ok(solde);
    }
}
