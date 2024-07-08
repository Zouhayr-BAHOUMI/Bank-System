package Wafacash.repository;

import Wafacash.model.Beneficiaire;
import Wafacash.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Integer> {
}
