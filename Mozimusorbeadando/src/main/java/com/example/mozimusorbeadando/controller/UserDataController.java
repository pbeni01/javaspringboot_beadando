package com.example.mozimusorbeadando.controller;

import com.example.mozimusorbeadando.model.Film;
import com.example.mozimusorbeadando.model.Hely;
import com.example.mozimusorbeadando.model.Mozi;
import com.example.mozimusorbeadando.repository.FilmRepository;
import com.example.mozimusorbeadando.repository.HelyRepository;
import com.example.mozimusorbeadando.repository.MoziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserDataController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private HelyRepository helyRepository;

    @Autowired
    private MoziRepository moziRepository;

    @GetMapping("/data")
    public String dataPage(Model model) {
        // Adatok lekérése az adatbázisból
        List<Film> film = filmRepository.findAll();
        List<Hely> hely = helyRepository.findAll();
        List<Mozi> mozi = moziRepository.findAll();

        // Adatok átadása a sablonnak
        model.addAttribute("film", film);
        model.addAttribute("hely", hely);
        model.addAttribute("mozi", mozi);

        return "data"; // A Thymeleaf sablon neve
    }
}
