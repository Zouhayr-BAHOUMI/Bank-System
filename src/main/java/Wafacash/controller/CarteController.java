package Wafacash.controller;


import Wafacash.model.Carte;
import Wafacash.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carte")
public class CarteController {

    @Autowired
    private CarteService carteService;


    @PostMapping("/add")
    public ResponseEntity<String> ajouterCarte(@RequestBody Carte carte){
        try {
            carteService.addCarte(carte);
            return ResponseEntity.status(HttpStatus.CREATED).body("created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created" + e.getMessage());
        }
    }
}
