package com.investasi.service;

import com.investasi.model.*;
import com.investasi.util.InputUtil;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private static List<User> users = new ArrayList<>();
    private static User currentUser;

    static {
        users.add(new Admin("admin", "admin123"));
        users.add(new Customer("user", "user123"));
    }

    public void login() {
        System.out.println("\n=== Login ===");
        String username = InputUtil.input("Username: ").trim();
        String password = InputUtil.input("Password: ").trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username atau password tidak boleh kosong.\n");
            return;
        }

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login berhasil sebagai " + username + "\n");
                if (user instanceof Admin) {
                    new MenuService().menuAdmin();
                } else {
                    new MenuService().menuCustomer((Customer) user);
                }
                return;
            }
        }
        System.out.println("Login gagal. Username atau password salah.\n");
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}