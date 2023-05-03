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
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditService {

    private final ClientAccountResources clientAccountResources;
    private final CreateCardEmit cardEmit;private BigDecimal limit;

    public AccountData getAccountData(String id) {
        ResponseEntity<AccountData> accountData = clientAccountResources.getAccountData(id);
        return accountData.getBody();
    }

    public BigDecimal calculateCredit(String id) {
        AccountData accountData = this.getAccountData(id);
        double percent = 0.4;
        BigDecimal limit = accountData.getIncome().multiply(BigDecimal.valueOf(percent));
        this.limit = limit;
        return limit;
    }

    public RequestCardDataProtocol requestCard(String id) {
        try {
            if (this.limit == null){
                throw new ErroResponse("Erro ao criar cartão, limite não definido");
            }

            RequestCardData requestCardData = new RequestCardData();
            requestCardData.setCardLimit(this.limit);
            requestCardData.setIdentifier(id);

            cardEmit.requestCard(requestCardData);
            var protocol = UUID.randomUUID().toString();
            return new RequestCardDataProtocol(protocol, id, this.limit);

        } catch (JsonProcessingException | ErroResponse e) {
            throw new RuntimeException(e);
        }
    }


}
