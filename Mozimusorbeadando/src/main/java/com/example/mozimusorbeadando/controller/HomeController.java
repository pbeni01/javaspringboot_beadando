package com.example.mozimusorbeadando.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            model.addAttribute("isLoggedIn", true);
            model.addAttribute("username", authentication.getName());

            // Szerepkör lekérdezése (kis-nagybetű különbség figyelembevétele nélkül)
            String role = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .filter(r -> r.equalsIgnoreCase("ADMIN")) // Kis-nagybetű figyelmen kívül hagyása
                    .findFirst()
                    .orElse("USER");

            model.addAttribute("role", role); // Szerepkör átadása a sablonnak
        } else {
            model.addAttribute("isLoggedIn", false);
        }

        return "index"; // Az index.html sablon neve
    }
}
