package com.veterinaria.veterinariaback.service;

import com.veterinaria.veterinariaback.dao.RafMascotaDAO;
import com.veterinaria.veterinariaback.dto.RafMascota;
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

class RafMascotasServiceImplTest {


    RafMascota rafMascota;

    @InjectMocks
    private RafMascotasServiceImpl rafMascotasServiceImpl;

    @Mock
    private RafMascotaDAO rafMascotaDAO;

    @Mock
    private Logger log;


    @BeforeEach
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);

        if(rafMascotasServiceImpl == null) {
            rafMascotasServiceImpl = new RafMascotasServiceImpl(rafMascotaDAO);
        }

        if(rafMascota == null) {
            rafMascota = new RafMascota();
            rafMascota.setNmid(1);
            rafMascota.setDsnombre_mascota("dsnombre_mascota");
            rafMascota.setNmid_especie(1);
            rafMascota.setDsraza("dsraza");
            rafMascota.setDtfecha_nacimiento(LocalDate.parse("2020-06-01"));
            rafMascota.setNmid_dueno(1);
            rafMascota.setDsespecie("dsespecie");
        }
    }

    @Test
    void findAll() {
        doNothing().when(log).debug("Prueba", rafMascota);
        when(rafMascotaDAO.getAll()).thenReturn(Arrays.asList(rafMascota));
        assertNotNull(rafMascotasServiceImpl.findAll());
    }

    @Test
    void findOne() {
        doNothing().when(log).debug("Prueba", rafMascota);
        when(rafMascotaDAO.getById(1)).thenReturn(rafMascota);
        assertNotNull(rafMascotasServiceImpl.findOne(1));
    }

    @Test
    void findOneMascota() {
        doNothing().when(log).debug("Prueba", rafMascota);
        when(rafMascotaDAO.getByIdMascota(1)).thenReturn(Arrays.asList(rafMascota));
        assertNotNull(rafMascotasServiceImpl.findOneMascota(1));
    }

    @Test
    void save() {
        doNothing().when(log).debug("Prueba", rafMascota);
        when(rafMascotaDAO.insert(rafMascota)).thenReturn(rafMascota);
        RafMascota res = rafMascotasServiceImpl.save(rafMascota);
        assertNotNull(res);
    }

    @Test
    void update() {
        doNothing().when(log).debug("Prueba", rafMascota);
        when(rafMascotaDAO.update(rafMascota)).thenReturn(rafMascota);
        assertNotNull(rafMascotasServiceImpl.update(rafMascota));
    }
}