package io.github.valtergabriell.mslogin.application;

import io.github.valtergabriell.mslogin.application.dto.AccountData;
import io.github.valtergabriell.mslogin.infra.ClientAccountResources;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final ClientAccountResources clientAccountResources;


    public AccountData getAccountData(String cpf) {
        log.info("Getting into account data service: " + cpf);
        ResponseEntity<AccountData> accountData = clientAccountResources.getAccountData(cpf);
        log.info("Return account body: " + accountData.getBody());
        return accountData.getBody();
    }
}
