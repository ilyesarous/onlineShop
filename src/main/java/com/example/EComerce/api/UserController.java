package com.example.EComerce.api;

import com.example.EComerce.model.Produit;
import com.example.EComerce.model.User;
import com.example.EComerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping (value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "signin")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PostMapping(path = "login")
    public String login(@RequestBody User user){
        return userService.login(user);
    }
    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping(path = "{id}")
    public Optional<User> getUserByID(@PathVariable("id") UUID id){
        return userService.getUserByID(id);
    }
//Produit
    @PostMapping(path = "/product/add")
    public String addProduct(@RequestBody Produit produit){
        return userService.addProduct(produit);
    }

    @DeleteMapping(path = "/product/min/{id1}")
    public String removeProductByID(@PathVariable("id1") UUID id){
        return userService.removeProductByID(id);
    }

    @GetMapping(path = "/products")
    public List<Produit> showProducts(){
        return userService.showProducts();
    }
    @GetMapping(path = "/product/{id1}")
    public Optional<Produit> selcetProductByID(@PathVariable("id1") UUID id){
        return userService.selcetProductByID(id);
    }

    @PutMapping(path = "/product/add/quantitee/{id1}")
    public int addQte(@PathVariable("id1") UUID id, @RequestBody Produit produit){
        return userService.addQte(id, produit);
    }
    @PutMapping(path = "/product/min/quantitee/{id1}")
    public int substructQte(@PathVariable("id1") UUID id, @RequestBody Produit produit){
        return userService.substructQte(id, produit);
    }

    @GetMapping(path = "product/quantitee")
    public int showQte(UUID id){
        return userService.showQte(id);
    }

}
