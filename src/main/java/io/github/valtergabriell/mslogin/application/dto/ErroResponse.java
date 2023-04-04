package io.github.valtergabriell.mslogin.application.dto;

import lombok.Data;

public class ErroResponse extends Exception {
    public ErroResponse(String message) {
        super(message);
    }
}
