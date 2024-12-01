package com.example.mozimusorbeadando.repository;

import com.example.mozimusorbeadando.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}