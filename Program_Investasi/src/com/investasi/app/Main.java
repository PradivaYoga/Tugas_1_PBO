package com.investasi.app;

import com.investasi.service.AuthService;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        authService.login();
    }
}