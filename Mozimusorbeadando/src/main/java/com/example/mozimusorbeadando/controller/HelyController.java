package com.example.mozimusorbeadando.controller;

import com.example.mozimusorbeadando.model.Hely;
import com.example.mozimusorbeadando.repository.HelyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hely")
public class HelyController {

    private final HelyRepository helyRepository;

    public HelyController(HelyRepository helyRepository) {
        this.helyRepository = helyRepository;
    }

    @GetMapping
    public List<Hely> getAllHely() {
        return helyRepository.findAll();
    }

    @PostMapping
    public Hely createHely(@RequestBody Hely hely) {
        return helyRepository.save(hely);
    }
}