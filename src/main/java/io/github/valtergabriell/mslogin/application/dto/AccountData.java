package io.github.valtergabriell.mslogin.application.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class AccountData {

    private String identifier;

    private LocalDate accountDate;

    private String clientName;

    private String clientPhoneNumber;

    private String clientEmail;

    private BigDecimal income;
}
