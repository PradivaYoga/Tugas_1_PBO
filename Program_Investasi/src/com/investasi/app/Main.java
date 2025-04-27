package com.investasi.app;

import com.investasi.service.AuthService;
import com.investasi.util.*;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        authService.login();
    }
}