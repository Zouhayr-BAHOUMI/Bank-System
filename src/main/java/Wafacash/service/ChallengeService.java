//package Wafacash.service;
//
//
//import Wafacash.model.Compte;
//import Wafacash.model.Transaction;
//import Wafacash.model.Transfert;
//import Wafacash.repository.CompteRepository;
//import Wafacash.repository.TransactionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ChallengeService {
//
//    @Autowired
//    private CompteRepository compteRepository;
//
//    private TransactionRepository transactionRepository;
//
//    public double calculerSolde(){
//
//        List<Compte> comptes = compteRepository.findAll();
//
//        double soldeTotal = comptes.stream().mapToDouble(Compte::getSoldeInitial).sum();
//
//       return soldeTotal;
//    }
//
//    public List<Transaction> allTransaction(){
//        List<Transaction> transactions = transactionRepository.findAll();
//
//        String DateSpecifie = "2024-07-08T11:21:35.444102500";
//
//        return transactions.stream().filter(t -> t.getDateTransaction().equals(DateSpecifie))
//                .collect(Collectors.toList());
//    }
//
//
//}
