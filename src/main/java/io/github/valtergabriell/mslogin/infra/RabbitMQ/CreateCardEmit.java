package io.github.valtergabriell.mslogin.infra.RabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.valtergabriell.mslogin.application.dto.RequestCardData;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCardEmit {

    private final RabbitTemplate rabbitTemplate;
    private final Queue createCardQueue;

    public void requestCard(RequestCardData requestCardData) throws JsonProcessingException {
        var json = convertToJson(requestCardData);
        rabbitTemplate.convertAndSend(createCardQueue.getName(), json);
    }

    private String convertToJson(RequestCardData requestCardData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(requestCardData);
        return json;
    }



}
