package com.example.EComerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Produit {

    private UUID id;
    private int qte;
    private String productName;

    public Produit(@JsonProperty("id") UUID id,@JsonProperty("productName") String productName,@JsonProperty("qte") int qte){
        this.id = id;
        this.qte = qte;
        this.productName = productName;
    }

    public UUID getId() {
        return id;
    }

    public int getQte() {
        return qte;
    }

    public String getProductName() {
        return productName;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
