package Wafacash.controller;


import Wafacash.model.Compte;
import Wafacash.model.Transaction;
import Wafacash.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/add")
    private String ajouterTransaction(@RequestBody Transaction transaction) throws Exception {
        transactionService.addtTransaction(transaction);
        return "added successfully";
    }
}
