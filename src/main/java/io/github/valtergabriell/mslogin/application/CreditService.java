package io.github.valtergabriell.mslogin.application;

import io.github.valtergabriell.mslogin.application.dto.AccountData;
import io.github.valtergabriell.mslogin.infra.ClientAccountResources;
import io.github.valtergabriell.mslogin.infra.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditService {

    private final ClientAccountResources clientAccountResources;
    private final ClientRepository clientRepository;


    public AccountData getAccountData(String cpf) {
        ResponseEntity<AccountData> accountData = clientAccountResources.getAccountData(cpf);
        return accountData.getBody();
    }

}
