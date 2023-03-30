package com.veterinaria.veterinariaback.config.controller;

import com.veterinaria.veterinariaback.config.controller.error.ApplicationCustomException;
import com.veterinaria.veterinariaback.dto.RafDuenos;
import com.veterinaria.veterinariaback.service.RafDuenosServiceImpl;
import com.veterinaria.veterinariaback.util.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RafDuenosControllerTest {
    int nmid = 1;
    RafDuenos rafDuenos;

    @InjectMocks
    private RafDuenosController rafDuenosController;

    @Mock
    private RafDuenosServiceImpl rafDuenosService;

    @Mock
    private Logger log;

    @BeforeEach
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);

        if(rafDuenos == null) {
            rafDuenos = new RafDuenos();
        }
    }

    @Test
    void getAllResponse() {
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafDuenosService.findAll()).willReturn(null);
        ResponseEntity<ResponseMessage<List<RafDuenos>>> res =  rafDuenosController.getAllResponse();
        assertNotNull(res);
    }

    @Test
    void createDueno() throws ApplicationCustomException {
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafDuenosService.save(rafDuenos)).willReturn(rafDuenos);
        ResponseEntity<ResponseMessage<RafDuenos>> res =  rafDuenosController.createDueno(rafDuenos);
        assertNotNull(res);
    }

    @Test
    void getDuenoException() throws ApplicationCustomException {
        doNothing().when(log).debug("Prueba", nmid);
        BDDMockito.given(rafDuenosService.findOne(nmid)).willReturn(rafDuenos);
        ResponseEntity<ResponseMessage<RafDuenos>> res =  rafDuenosController.getDueno(nmid);
        assertNotNull(res);
    }

    @Test
    void getDueno() {
        doNothing().when(log).debug("Prueba", nmid);
        BDDMockito.given(rafDuenosService.findOne(nmid)).willReturn(null);
        Exception exception = assertThrows(ApplicationCustomException.class, () -> {
            rafDuenosController.getDueno(nmid);
        });
        String actualMessage = exception.getMessage();
        assertNotNull(actualMessage);
    }

    @Test
    void createDuenoException(){
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafDuenosService.findOne(rafDuenos.getNmid())).willReturn(rafDuenos);
        Exception exception = assertThrows(ApplicationCustomException.class, () -> {
            rafDuenosController.createDueno(rafDuenos);
        });
        String actualMessage = exception.getMessage();
        assertNotNull(actualMessage);
    }

    @Test
    void updateDuenos() {
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafDuenosService.update(rafDuenos)).willReturn(rafDuenos);
        Exception exception = assertThrows(ApplicationCustomException.class, () -> {
            rafDuenosController.updateDuenos(new RafDuenos());
        });
        String actualMessage = exception.getMessage();
        assertNotNull(actualMessage);
    }
}