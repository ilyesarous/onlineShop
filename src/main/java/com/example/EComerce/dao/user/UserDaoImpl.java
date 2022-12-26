package com.example.EComerce.dao.user;

import com.example.EComerce.model.Produit;
import com.example.EComerce.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("user")
public class UserDaoImpl implements  IUserDao{

    List<User> users = new ArrayList<User>();
    @Override
    public int signup(UUID id, User user) {
        if(verifUserByEmailAndPassword(user.getEmail(), user.getPassword())){
            return 0;
        }else {
            users.add(new User(id, user.getName(),user.getEmail(), user.getPassword()));
            return 1;
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public String login(String email, String password) {
        String mes = "";
        for(User x : users) {
            if (x.getEmail().equals(email)) {
                if (x.getPassword().equals(password)) {
                    mes= "welcome! " + x.getName();
                } else {
                    mes= "password incorrect!";
                }
            } else {
                mes= "user doesn't exist!";
            }
        }
        return mes;
    }

    @Override
    public boolean verifUserByEmailAndPassword(String email, String password) {
        for (User u : users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password))
                return true;
        }
        return false;
    }

    @Override
    public Optional<User> selectUserByID(UUID id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }


    List<Produit> products = new ArrayList<Produit>();
    @Override
    public int addQte(UUID id, Produit produit) {
        return selcetProductByID(id).map(p->{
            int index = products.indexOf(p);
            if(index>=0){
                products.set(index,new Produit(id, produit.getProductName(), produit.getQte()+p.getQte()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int substructQte(UUID id, Produit produit) {
        return selcetProductByID(id).map(p->{
            int index = products.indexOf(p);
            if(index>=0){
                products.set(index,new Produit(id, produit.getProductName(), -produit.getQte()+p.getQte()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
    @Override
    public Optional<Produit> selcetProductByID(UUID id) {
        return products.stream().filter(produit -> produit.getId().equals(id)).findFirst();
    }

    @Override
    public int showQte(UUID id) {
        Optional<Produit> p = selcetProductByID(id);
        if(p.isEmpty())
            return -1;
        return p.get().getQte();
    }

    @Override
    public List<Produit> showProducts() {
        return products;
    }

    @Override
    public String addProduct(UUID id, Produit produit) {
        products.add(new Produit(id, produit.getProductName(), produit.getQte()));
        return "product added successfully";
    }

    @Override
    public String removeProductByID(UUID id) {
        Optional<Produit> p = selcetProductByID(id);
        if(p.isEmpty())
            return "Product is not found";
        products.remove(p.get());
        return "Product was deleted successfully";
    }

}
