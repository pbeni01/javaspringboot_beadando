package com.example.mozimusorbeadando.repository;

import com.example.mozimusorbeadando.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
