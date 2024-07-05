package Wafacash.service;


import Wafacash.model.Compte;
import Wafacash.model.Transaction;
import Wafacash.model.User;
import Wafacash.repository.CompteRepository;
import Wafacash.repository.TransactionRepository;
import Wafacash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void addCompte(Compte compte) {

        if(compte.getUser() != null && userRepository.existsById(compte.getUser().getIdUser())){
            compteRepository.save(compte);
        }else {
            System.out.println("user not existe");
        }
    }

    //
    public double getSolde(int id_compte) throws Exception {
        Compte soldeCompte = compteRepository.findById(id_compte).
                orElseThrow(()-> new Exception("compte non trouve"));

        return soldeCompte.getSoldeInitial();

    }

    public List<Transaction> getHistorique(int idCompte){
        return transactionRepository.findByCompte_IdCompte(idCompte);
    }
}
