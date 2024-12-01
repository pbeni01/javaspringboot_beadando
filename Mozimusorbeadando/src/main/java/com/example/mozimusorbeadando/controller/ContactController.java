package com.example.mozimusorbeadando.controller;

import com.example.mozimusorbeadando.model.Message;
import com.example.mozimusorbeadando.repository.MessageRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("message", new Message());
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContactForm(@Valid @ModelAttribute("message") Message message,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        // Id biztosan ne legyen null értékkel
        message.setId(null);
        messageRepository.save(message);
        model.addAttribute("successMessage", "Üzenetét sikeresen elküldtük!");
        return "contact";
    }

}
