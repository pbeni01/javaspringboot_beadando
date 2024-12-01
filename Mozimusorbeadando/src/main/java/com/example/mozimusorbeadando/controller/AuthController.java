package com.example.mozimusorbeadando.controller;

import com.example.mozimusorbeadando.model.User;
import com.example.mozimusorbeadando.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Login oldal megjelenítése
     */
    @GetMapping("/login")
    public String login() {
        return "login"; // A login.html sablon neve a templates mappában
    }

    /**
     * Regisztrációs oldal megjelenítése
     */
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User()); // Üres User objektum az űrlaphoz
        return "register"; // A register.html sablon neve a templates mappában
    }

    /**
     * Regisztrációs kérelem kezelése
     */
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {
        // Ellenőrizzük, hogy a felhasználónév már létezik-e
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "A felhasználónév már létezik!");
            return "register"; // Visszatérünk a regisztrációs oldalra hibaüzenettel
        }

        // Jelszó kódolása és alapértelmezett szerepkör beállítása
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // Az alapértelmezett szerepkör beállítása

        // Felhasználó mentése az adatbázisba
        userRepository.save(user);

        // Sikeres regisztráció üzenet hozzáadása és átirányítás a bejelentkezési oldalra
        redirectAttributes.addFlashAttribute("message", "Sikeres regisztráció! Most jelentkezz be.");
        return "redirect:/login";
    }
}
