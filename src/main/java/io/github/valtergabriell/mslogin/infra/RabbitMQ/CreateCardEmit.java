package io.github.valtergabriell.mslogin.infra.RabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.valtergabriell.mslogin.application.dto.RequestCardData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateCardEmit {

    private final RabbitTemplate rabbitTemplate;
    private final Queue createCardQueue;

    public void requestCard(RequestCardData requestCardData) throws JsonProcessingException {
        try {
            var json = convertToJson(requestCardData);
            log.info(json);
            rabbitTemplate.convertAndSend(createCardQueue.getName(), json);
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }

    private String convertToJson(RequestCardData requestCardData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(requestCardData);
        return json;
    }



}
