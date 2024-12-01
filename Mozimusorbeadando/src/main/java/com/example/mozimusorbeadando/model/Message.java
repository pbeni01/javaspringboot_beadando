package com.example.mozimusorbeadando.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "A név megadása kötelező!")
    @Size(max = 50, message = "A név maximum 50 karakter lehet.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Az e-mail cím megadása kötelező!")
    @Email(message = "Kérjük, érvényes e-mail címet adjon meg!")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Az üzenet megadása kötelező!")
    @Size(max = 500, message = "Az üzenet maximum 500 karakter lehet.")
    @Column(name = "message")
    private String message;

    // Getterek és setterek
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

