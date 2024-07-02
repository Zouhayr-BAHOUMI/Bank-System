package Wafacash.controller;


import Wafacash.model.User;
import Wafacash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String ajouterUser(@RequestBody User user){

        userService.addUser(user);
        return "added successfully";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerUser(@PathVariable Integer id){

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }


}
