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

    @GetMapping(value = "account-data", params = "id")
    public ResponseEntity getAccountData(@RequestParam("id") String id) {
        AccountData accountData = creditService.getAccountData(id);
        return ResponseEntity.ok(accountData);
    }

    @GetMapping(value = "limit", params = {"id"})
    public ResponseEntity getCreditLimit(@RequestParam("id") String id) {
        BigDecimal bigDecimal = creditService.calculateCredit(id);
        return ResponseEntity.ok(bigDecimal);
    }

    @PostMapping(value = "request", params = {"id"})
    public ResponseEntity requestCard(@RequestParam("id") String id) {
        try {
            RequestCardDataProtocol requestCardDataProtocol = creditService.requestCard(id);
            return ResponseEntity.ok(requestCardDataProtocol);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
}
