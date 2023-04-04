package io.github.valtergabriell.mslogin.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RequestCardDataProtocol {

    private String protocolValue;
    private String cpf;
    private BigDecimal limitApproved;


}
