package io.github.valtergabriell.mslogin.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestCardData {
    private String cardId;
    private BigDecimal cardLimit;

}
