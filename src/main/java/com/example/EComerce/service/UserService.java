package com.example.EComerce.service;

import com.example.EComerce.dao.user.IUserDao;
import com.example.EComerce.model.Produit;
import com.example.EComerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final IUserDao userDao;
    private final IUserDao produitDao;

    @Autowired
    public UserService(@Qualifier("user") IUserDao userDao, IUserDao produitDao){
        this.userDao = userDao;
        this.produitDao = produitDao;
    }

    public int addUser(User user){
        return userDao.signup(user);
    }

    public String login(User user){
        return userDao.login(user.getEmail(),user.getPassword());
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public Optional<User> getUserByID(UUID id){
        return userDao.selectUserByID(id);
    }



    public String addProduct(Produit produit){
        return produitDao.addProduct(produit);
    }
    public String removeProductByID(UUID id){
        return produitDao.removeProductByID(id);
    }
    public List<Produit> showProducts(){
        return produitDao.showProducts();
    }
    public Optional<Produit> selcetProductByID(UUID id){
        return produitDao.selcetProductByID(id);
    }
    public int addQte(UUID id, Produit produit){
        return produitDao.addQte(id, produit);
    }
    public int substructQte(UUID id, Produit produit){
        return produitDao.substructQte(id, produit);
    }
    public int showQte(UUID id){
        return produitDao.showQte(id);
    }
}
