package com.veterinaria.veterinariaback.config.controller;

import com.veterinaria.veterinariaback.config.controller.error.ApplicationCustomException;
import com.veterinaria.veterinariaback.dto.RafMascota;
import com.veterinaria.veterinariaback.service.RafMascotasServiceImpl;
import com.veterinaria.veterinariaback.util.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;

class RafMascotaControllerTest {
    int  nmid_dueno= 1;
    int nmid = 1;
    RafMascota rafMascota;

    @InjectMocks
    private RafMascotaController rafMascotaController;

    @Mock
    private RafMascotasServiceImpl rafMascotaService;

    @Mock
    private Logger log;

    @BeforeEach
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);

        if(rafMascota == null) {
            rafMascota = new RafMascota();
        }
    }

    @Test
    void getAllResponse() {
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafMascotaService.findAll()).willReturn(null);
        ResponseEntity<ResponseMessage<List<RafMascota>>> res =  rafMascotaController.getAllResponse();
        assertNotNull(res);
    }

    @Test
    void createMascotas() throws ApplicationCustomException  {
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafMascotaService.save(rafMascota)).willReturn(rafMascota);
        ResponseEntity<ResponseMessage<RafMascota>> res =  rafMascotaController.createMascotas(rafMascota);
        assertNotNull(res);
    }

    @Test
    void updateMascotas() {
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafMascotaService.update(rafMascota)).willReturn(rafMascota);
        Exception exception = assertThrows(ApplicationCustomException.class, () -> {
            rafMascotaController.updateMascotas(new RafMascota());
        });
        String actualMessage = exception.getMessage();
        assertNotNull(actualMessage);
    }

    @Test
    void getMascotas() throws ApplicationCustomException {
        doNothing().when(log).debug("Prueba", nmid_dueno);
        BDDMockito.given(rafMascotaService.findOne(nmid_dueno)).willReturn(null);
        ResponseEntity<ResponseMessage<List<RafMascota>>> res =  rafMascotaController.getMascotas(nmid_dueno);
        assertNotNull(res);
    }

    @Test
    void createMascotasException(){
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(rafMascotaService.findOne(rafMascota.getNmid())).willReturn(rafMascota);
        Exception exception = assertThrows(ApplicationCustomException.class, () -> {
            rafMascotaController.createMascotas(rafMascota);
        });
        String actualMessage = exception.getMessage();
        assertNotNull(actualMessage);
    }

    @Test
    void getMascotasIF() throws ApplicationCustomException {
        RafMascotasServiceImpl rafMascotaService = Mockito.mock(RafMascotasServiceImpl.class);
        RafMascotaController rafMascotaController = new RafMascotaController(rafMascotaService);
        List<RafMascota> rafMascotaMock = Mockito.mock(List.class);
        Mockito.when(rafMascotaService.findOneMascota(Mockito.anyInt())).thenReturn(rafMascotaMock);
        rafMascotaController.getMascotas(1);
        Mockito.verify(rafMascotaService, Mockito.times(1)).findOneMascota(1);
        Mockito.when(rafMascotaService.findOneMascota(Mockito.anyInt())).thenReturn(null);
        assertThrows(ApplicationCustomException.class, () -> rafMascotaController.getMascotas(1));
    }
}