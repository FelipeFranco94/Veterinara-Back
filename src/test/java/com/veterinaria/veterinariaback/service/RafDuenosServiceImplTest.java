package com.veterinaria.veterinariaback.service;

import com.veterinaria.veterinariaback.dao.RafDuenosDAO;
import com.veterinaria.veterinariaback.dto.RafDuenos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class RafDuenosServiceImplTest {

    RafDuenos rafDuenos;

    @InjectMocks
    private RafDuenosServiceImpl rafDuenosServiceImpl;

    @Mock
    private RafDuenosDAO rafDuenosDAO;

    @Mock
    private Logger log;

    @BeforeEach
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);

        if(rafDuenosServiceImpl == null) {
            rafDuenosServiceImpl = new RafDuenosServiceImpl(rafDuenosDAO);
        }

        if(rafDuenos == null) {
            rafDuenos = new RafDuenos();
            rafDuenos.setNmid(1);
            rafDuenos.setDsnombre_dueno("dsnombre_dueno");
            rafDuenos.setDstipo_documento("dstipo_documento");
            rafDuenos.setNmidentificacion(1L);
            rafDuenos.setDsciudad("dsciudad");
            rafDuenos.setDsdireccion("dsdireccion");
            rafDuenos.setNmtelefono(1L);
            rafDuenos.setDtfecha_registro(LocalDate.parse("2020-06-01"));
        }
    }

    @Test
    void save() {
        doNothing().when(log).debug("Prueba", rafDuenos);
        when(rafDuenosDAO.insert(rafDuenos)).thenReturn(rafDuenos);
        RafDuenos res = rafDuenosServiceImpl.save(rafDuenos);
        assertNotNull(res);
    }

    @Test
    void findAll() {
        doNothing().when(log).debug("Prueba", rafDuenos);
        when(rafDuenosDAO.getAll()).thenReturn(Arrays.asList(rafDuenos));
        assertNotNull(rafDuenosServiceImpl.findAll());
    }

    @Test
    void findOne() {
        doNothing().when(log).debug("Prueba", rafDuenos);
        when(rafDuenosDAO.getById(1)).thenReturn(rafDuenos);
        assertNotNull(rafDuenosServiceImpl.findOne(1));
    }

    @Test
    void update() {
        doNothing().when(log).debug("Prueba", rafDuenos);
        when(rafDuenosDAO.update(rafDuenos)).thenReturn(rafDuenos);
        assertNotNull(rafDuenosServiceImpl.update(rafDuenos));
    }
}