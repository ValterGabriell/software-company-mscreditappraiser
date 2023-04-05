package io.github.valtergabriell.mslogin.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestCardData {
    private String cpf;
    private BigDecimal cardLimit;

}
