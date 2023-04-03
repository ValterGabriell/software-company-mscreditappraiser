package io.github.valtergabriell.mslogin.application.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data
public class Client {

    @Id
    @Column(length = 14, nullable = false)
    String cpf;

    @Column(name = "email", nullable = false)
    String username;


    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "token", nullable = false)
    String token;


}
