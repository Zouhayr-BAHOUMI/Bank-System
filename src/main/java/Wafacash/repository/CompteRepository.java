package Wafacash.repository;

import Wafacash.model.Compte;
import Wafacash.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
}
