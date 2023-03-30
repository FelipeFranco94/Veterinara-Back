package com.veterinaria.veterinariaback.util;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

class ResponseMessageTest {

    @Spy
    @InjectMocks
    private ResponseMessage responseMessage;

  @Test
    public void setCodigo() {
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        int code = 200;
        String message = "Hola mundo";

        responseMessage.setCodigo(code);
        assertEquals(code, responseMessage.getCode());
        responseMessage.setMessage(message);
        assertEquals(message, responseMessage.getMessage());

    }
}