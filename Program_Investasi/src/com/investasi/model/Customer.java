package com.investasi.model;

public class Customer extends User {
    private Portofolio portofolio;

    public Customer(String username, String password) {
        super(username, password);
        this.portofolio = new Portofolio();
    }

    public Portofolio getPortofolio() {
        return portofolio;
    }
}