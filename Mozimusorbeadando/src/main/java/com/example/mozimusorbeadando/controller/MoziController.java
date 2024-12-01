package com.example.mozimusorbeadando.controller;

import com.example.mozimusorbeadando.model.Mozi;
import com.example.mozimusorbeadando.repository.MoziRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mozik")
public class MoziController {

    private final MoziRepository moziRepository;

    public MoziController(MoziRepository moziRepository) {
        this.moziRepository = moziRepository;
    }

    @GetMapping
    public List<Mozi> getAllMozik() {
        return moziRepository.findAll();
    }

    @PostMapping
    public Mozi createMozi(@RequestBody Mozi mozi) {
        return moziRepository.save(mozi);
    }
}
