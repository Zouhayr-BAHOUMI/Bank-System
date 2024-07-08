package Wafacash.controller;


import Wafacash.model.Beneficiaire;
import Wafacash.model.Carte;
import Wafacash.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beneficiaire")
public class BeneficiaireController {

    @Autowired
    private BeneficiaireService beneficiaireService;

    @PostMapping("/add")
    public ResponseEntity<String> ajouterBeneficiaire(@RequestBody Beneficiaire beneficiaire){
        try {
            beneficiaireService.addBeneficiaire(beneficiaire);
            return ResponseEntity.status(HttpStatus.CREATED).body("created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created" + e.getMessage());
        }
    }


    @GetMapping("/idBeneficiaire")
    public Beneficiaire showsBeneficiaireById(@RequestParam Integer idBeneficiaire){
        Beneficiaire beneficiaire = beneficiaireService.getBeneficiaire(idBeneficiaire);
        return beneficiaire;
    }

    @PutMapping("/update/{idBeneficiaire}")
    public ResponseEntity<Void> modifierBeneficiaire(@PathVariable Integer idBeneficiaire, @RequestBody Beneficiaire beneficiaire){

        beneficiaireService.updateBeneficiaire(idBeneficiaire,beneficiaire);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{idBeneficiaire}")
    public ResponseEntity<Void>  supprimerBeneficiaire(@PathVariable Integer idBeneficiaire){

        beneficiaireService.deleteBeneficiaire(idBeneficiaire);

        return ResponseEntity.noContent().build();
    }


}
