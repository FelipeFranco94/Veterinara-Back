package com.veterinaria.veterinariaback.util;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseMessageTest {

    @Spy
    @InjectMocks
    private ResponseMessage ResponseMessage;

    @Test
    public void setCodigo() {
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        int code = 200;
        responseMessage.setCodigo(code);
        assertEquals(code, responseMessage.getCode());
    }
}