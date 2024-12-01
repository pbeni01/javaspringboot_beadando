package com.example.mozimusorbeadando.controller;

import com.example.mozimusorbeadando.model.User;
import com.example.mozimusorbeadando.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        // Adatok lekérése az adatbázisból (User tábla)
        List<User> users = userRepository.findAll();

        // Adatok átadása a sablonnak
        model.addAttribute("users", users);
        model.addAttribute("message", "Ez az admin oldal!");

        return "admin"; // Az admin.html sablon neve
    }
}
