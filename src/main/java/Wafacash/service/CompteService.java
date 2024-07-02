package Wafacash.service;


import Wafacash.model.Compte;
import Wafacash.model.User;
import Wafacash.repository.CompteRepository;
import Wafacash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompteRepository compteRepository;

    public void addCompte(Compte compte) {

        if(compte.getUser() != null && userRepository.existsById(compte.getUser().getIdUser())){
            compteRepository.save(compte);
        }else {
            System.out.println("user not existe");
        }
    }
}
