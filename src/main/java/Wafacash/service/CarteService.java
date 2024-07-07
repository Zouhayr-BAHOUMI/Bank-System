package Wafacash.service;


import Wafacash.enums.CarteStatus;
import Wafacash.model.Carte;
import Wafacash.model.Compte;
import Wafacash.repository.CarteRepository;
import Wafacash.repository.CompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class CarteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private CarteRepository carteRepository;


    @Transactional
    public void addCarte(Carte carte){
        Compte compteCheck = compteRepository.findById(carte.getCompte().getIdCompte()).
                orElseThrow(()-> new RuntimeException("compte non trouve"));

        carte.setCompte(compteCheck);
        carte.setNumeroCarte(carteNumero(Integer.parseInt("4")));
        carte.setDateExpiration(dateExpiration(10));
        carte.setCarteStatus(CarteStatus.desactive);

        carteRepository.save(carte);
    }

    public void getStatusCarte(int idCarte, boolean isActive){
        Carte carteActivited = carteRepository.findById(idCarte)
                .orElseThrow(() -> new RuntimeException("carte not found"));

        if (isActive){
            carteActivited.setCarteStatus(CarteStatus.active);
        }else {
            carteActivited.setCarteStatus(CarteStatus.desactive);
        }
        carteRepository.save(carteActivited);
    }










    private String carteNumero(int startNum) {
        Random random = new Random();
        StringBuilder numeroCarte = new StringBuilder();

        numeroCarte.append(startNum);

        for(int i=0 ; i<15 ; i++){
            numeroCarte.append(random.nextInt(10));
        }

        return numeroCarte.toString();
    }


    private String dateExpiration(int yearsAdded) {
        LocalDate currentDate = LocalDate.now();
        LocalDate expireDate = currentDate.plusYears(yearsAdded);
        DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("MM/yy");
        return expireDate.format(patternDate);
    }


}
