package io.github.valtergabriell.mslogin.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.valtergabriell.mslogin.application.dto.AccountData;
import io.github.valtergabriell.mslogin.application.dto.ErroResponse;
import io.github.valtergabriell.mslogin.application.dto.RequestCardData;
import io.github.valtergabriell.mslogin.application.dto.RequestCardDataProtocol;
import io.github.valtergabriell.mslogin.infra.ClientAccountResources;
import io.github.valtergabriell.mslogin.infra.RabbitMQ.CreateCardEmit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditService {

    private final ClientAccountResources clientAccountResources;
    private final CreateCardEmit cardEmit;

    private String cpf;
    private BigDecimal limit;

    public AccountData getAccountData(String cpf) {
        ResponseEntity<AccountData> accountData = clientAccountResources.getAccountData(cpf);
        this.cpf = accountData.getBody().getCpf();
        return accountData.getBody();
    }

    public BigDecimal calculateCredit(String cpf) {
        AccountData accountData = this.getAccountData(cpf);
        int year = accountData.getBirthDate().getYear();
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;
        int percent = 40;
        BigDecimal limit = accountData.getIncome().multiply(BigDecimal.valueOf(age)).divide(BigDecimal.valueOf(percent));
        this.limit = limit;
        return limit;
    }

    public RequestCardDataProtocol requestCard(String cpf) {
        try {
            if (this.limit == null){
                throw new ErroResponse("Erro ao criar cartão, limite não definido");
            }

            RequestCardData requestCardData = new RequestCardData();
            requestCardData.setCardLimit(this.limit);
            requestCardData.setCpf(cpf);

            cardEmit.requestCard(requestCardData);
            var protocol = UUID.randomUUID().toString();
            return new RequestCardDataProtocol(protocol, cpf, this.limit);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (ErroResponse e) {
            throw new RuntimeException(e);
        }
    }


}
