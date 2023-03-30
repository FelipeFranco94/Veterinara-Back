package com.veterinaria.veterinariaback.config.controller.error;

import com.veterinaria.veterinariaback.util.ResponseMessage;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateExceptionTest {

    @InjectMocks
    private DuplicateException duplicateException;

    @Test
    public void testGetResponse() {
        int code = 409;
        String message = "Duplicate entry found";
        DuplicateException exception = new DuplicateException(code, message);

        ResponseMessage<Object> response = exception.getResponse();

        assertNotNull(response);
        assertEquals(code, response.getCode());
        assertEquals(message, response.getMessage());
        assertNull(response.getData());
    }
}