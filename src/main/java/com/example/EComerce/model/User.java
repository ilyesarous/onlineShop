package com.example.EComerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    private UUID id;
    private String name, email, password;

    public User(@JsonProperty("id") UUID id,@JsonProperty("name") String name,
                @JsonProperty("email") String email,@JsonProperty("password") String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
