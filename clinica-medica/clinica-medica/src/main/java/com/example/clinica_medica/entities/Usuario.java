package com.example.clinica_medica.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nome é Obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Column(nullable = false, unique = true, length = 11)
    @Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
    private String cpf;

    @Column(nullable = false)
    private Integer idade;

    @Email(message = "Email é inválido")
    @NotBlank(message = "Email é obrigatório")
    @Column(nullable = false, length = 100)
    private String email;

    @NotBlank(message = "Senha é Obrigatória")
    @Column(nullable = false, length = 100)
    private String senha;
}