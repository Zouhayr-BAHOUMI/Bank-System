package Wafacash.service;


import Wafacash.model.User;
import Wafacash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Movie not found for id :: " + id));

        userRepository.delete(user);
    }
}
