package Wafacash.repository;

import Wafacash.model.Carte;
import Wafacash.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository extends JpaRepository<Carte, Integer> {
}
