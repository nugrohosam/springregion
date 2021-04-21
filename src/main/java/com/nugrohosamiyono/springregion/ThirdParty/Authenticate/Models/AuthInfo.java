package com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Models;

public class AuthInfo {
    
    private double id;
    private String email;

    public double getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(double id) {
        this.id = id;
    }
}
