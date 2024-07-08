package Wafacash.service;


import Wafacash.model.Beneficiaire;
import Wafacash.repository.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BeneficiaireService {

    @Autowired
    private BeneficiaireRepository beneficiaireRepository;

    public void addBeneficiaire(Beneficiaire beneficiaire){
        beneficiaireRepository.save(beneficiaire);
    }

    public Beneficiaire getBeneficiaire(Integer idBeneficiaire) {

        Beneficiaire beneficiaire = beneficiaireRepository
                .findById(idBeneficiaire)
                .orElseThrow(() -> new NoSuchElementException("Movie not found for id :: " + idBeneficiaire));
        return beneficiaire;
    }

    public void updateBeneficiaire(Integer idBeneficiaire, Beneficiaire beneficiaire) {
        beneficiaireRepository
                .findById(idBeneficiaire)
                 .orElseThrow(()-> new RuntimeException("beneficiaire not found"));

        beneficiaire.setIdBeneficiaire(idBeneficiaire);

        beneficiaireRepository.save(beneficiaire);

    }


    public void deleteBeneficiaire(Integer idBeneficiaire){
        Beneficiaire beneficiaire = beneficiaireRepository
                .findById(idBeneficiaire)
                .orElseThrow(()-> new RuntimeException("beneficiaire not found"));

        beneficiaireRepository.delete(beneficiaire);
    }
}
