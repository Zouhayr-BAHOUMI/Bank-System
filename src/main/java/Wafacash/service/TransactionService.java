package Wafacash.service;


import Wafacash.model.Compte;
import Wafacash.model.Transaction;
import Wafacash.repository.CompteRepository;
import Wafacash.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;


    public void addtTransaction(Transaction transaction) throws Exception {

        Compte compte = compteRepository.findById(transaction.getCompte().getIdCompte())
                .orElseThrow(() -> new RuntimeException("Compte not found"));

        transaction.setCompte(compte);
        transaction.setDateTransaction(LocalDateTime.now().toString());

        if ("Credit".equals(transaction.getTypeTransaction())) {
            compte.setSoldeInitial(compte.getSoldeInitial() + transaction.getMontant());
        } else if ("Debit".equals(transaction.getTypeTransaction())) {
            if (compte.getSoldeInitial() < transaction.getMontant()) {
                throw new Exception("solde insufficient ");
            }
            compte.setSoldeInitial(compte.getSoldeInitial() - transaction.getMontant());
        } else {
            throw new Exception("error dans le type du transaction");
        }

        compteRepository.save(compte);
        transactionRepository.save(transaction);
    }
}
