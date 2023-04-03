package io.github.valtergabriell.mslogin.application;


import io.github.valtergabriell.mslogin.application.dto.AccountData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;


    @GetMapping
    public String ok() {
        return "ok";
    }

    @GetMapping(value = "account-data", params = "cpf")
    public ResponseEntity getAccountData(@RequestParam("cpf") String cpf) {
        AccountData accountData = loginService.getAccountData(cpf);
        return ResponseEntity.ok(accountData);
    }
}
