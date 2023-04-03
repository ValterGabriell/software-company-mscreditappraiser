package io.github.valtergabriell.mslogin.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AccountData {

    private String cpf;

    private LocalDate birthDate;

    private LocalDate accountDate;

    private String clientName;

    private String clientPhoneNumber;

    private String clientEmail;

    private String gender;

    private String password;
}
