package io.github.valtergabriell.mslogin.application;


import io.github.valtergabriell.mslogin.application.dto.AccountData;
import io.github.valtergabriell.mslogin.application.dto.RequestCardDataProtocol;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("credit")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;


    @GetMapping
    public String ok() {
        return "ok";
    }

    @GetMapping(value = "account-data", params = "cpf")
    public ResponseEntity getAccountData(@RequestParam("cpf") String cpf) {
        AccountData accountData = creditService.getAccountData(cpf);
        return ResponseEntity.ok(accountData);
    }

    @GetMapping(value = "limit", params = {"cpf"})
    public ResponseEntity getCreditLimit(@RequestParam("cpf") String cpf) {
        BigDecimal bigDecimal = creditService.calculateCredit(cpf);
        return ResponseEntity.ok(bigDecimal);
    }

    @PostMapping(value = "request", params = {"cpf"})
    public ResponseEntity requestCard(@RequestParam("cpf") String cpf) {
        try {
            RequestCardDataProtocol requestCardDataProtocol = creditService.requestCard(cpf);
            return ResponseEntity.ok(requestCardDataProtocol);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
}
