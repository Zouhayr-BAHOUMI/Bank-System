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

    @PostMapping("/{idCarte}/activate")
    public ResponseEntity<String> activeCarte(@PathVariable Integer idCarte){

        try {
            carteService.getStatusCarte(idCarte,true);
            return ResponseEntity.ok("Carte activée avec succès.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in the activation.");
        }

    }

    @PostMapping("/{idCarte}/desactivate")
    public ResponseEntity<String> desactiveCarte(@PathVariable Integer idCarte){

        try {
            carteService.getStatusCarte(idCarte,false);
            return ResponseEntity.ok("Carte desactivée avec succès.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in the desactivation.");
        }

    }

    @PostMapping("/{idCarte}/blocked")
    public ResponseEntity<String> blockeCarte(@PathVariable Integer idCarte,@RequestBody String messageFermeture){

        try {
            carteService.blockCarte(idCarte,messageFermeture);
            return ResponseEntity.ok("Carte blocked  avec succès.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in the blockage.");
        }

    }


}
