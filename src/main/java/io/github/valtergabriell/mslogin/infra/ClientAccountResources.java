package io.github.valtergabriell.mslogin.infra;

import io.github.valtergabriell.mslogin.application.dto.AccountData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msaccount", path = "/account")
public interface ClientAccountResources {

    @GetMapping(params = "cpf")
    ResponseEntity<AccountData> getAccountData(@RequestParam("cpf") String cpf);


}
