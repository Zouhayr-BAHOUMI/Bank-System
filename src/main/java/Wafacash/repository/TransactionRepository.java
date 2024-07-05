package Wafacash.repository;

import Wafacash.model.Compte;
import Wafacash.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByCompte_IdCompte(int idCompte);
}
