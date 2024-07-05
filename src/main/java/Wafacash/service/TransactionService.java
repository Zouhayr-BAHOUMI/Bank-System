package Wafacash.service;


import Wafacash.model.Compte;
import Wafacash.model.Transaction;
import Wafacash.repository.CompteRepository;
import Wafacash.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;


    public void addtTransaction(Transaction transaction) {

        if(transaction.getCompte() != null && compteRepository.existsById(transaction.getCompte().getIdCompte())){
            transactionRepository.save(transaction);
        }else {
            System.out.println("user not existe");
        }
    }
}
