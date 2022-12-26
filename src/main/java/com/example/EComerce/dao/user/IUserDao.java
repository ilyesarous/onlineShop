package com.example.EComerce.dao.user;

import com.example.EComerce.model.Produit;
import com.example.EComerce.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserDao {

    int signup(UUID id, User user);
    default int signup(User user){
        UUID id = UUID.randomUUID();
        return signup(id, user);
    }

    List<User> getUsers();
    String login(String email, String password);
    boolean verifUserByEmailAndPassword(String email, String password);
    Optional<User> selectUserByID(UUID id);


    int addQte(UUID id, Produit produit);

    int showQte(UUID id);

    List<Produit> showProducts();
    String addProduct(UUID id, Produit produit);
    default String addProduct(Produit produit){
        UUID id = UUID.randomUUID();
        return addProduct(id, produit);
    }
    String removeProductByID(UUID id);

    int substructQte(UUID id, Produit produit);

    Optional<Produit>selcetProductByID(UUID id);


}
