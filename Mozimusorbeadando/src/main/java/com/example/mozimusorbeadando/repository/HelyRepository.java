package com.example.mozimusorbeadando.repository;

import com.example.mozimusorbeadando.model.Hely;
import com.example.mozimusorbeadando.model.HelyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelyRepository extends JpaRepository<Hely, HelyId> {
}