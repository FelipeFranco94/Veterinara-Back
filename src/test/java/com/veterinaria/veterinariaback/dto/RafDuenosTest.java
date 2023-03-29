package com.veterinaria.veterinariaback.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RafDuenosTest {

    RafDuenos rafDuenos = new RafDuenos();

    int nmid = 1;
    String dsnombre_dueno = "Dueño";
    String dstipo_documento = "C.C";
    Long nmidentificacion = 1L;
    String dsciudad = "Ciudad";
    String dsdireccion = "direccion";
    Long nmtelefono = 1L;
    LocalDate dtfecha_registro = LocalDate.parse("2020-06-01");


    @Test
    public void dto_duenoe() {
        rafDuenos.setNmid(nmid);
        rafDuenos.setDsnombre_dueno(dsnombre_dueno);
        rafDuenos.setDstipo_documento(dstipo_documento);
        rafDuenos.setNmidentificacion(nmidentificacion);
        rafDuenos.setDsciudad(dsciudad);
        rafDuenos.setDsdireccion(dsdireccion);
        rafDuenos.setNmtelefono(nmtelefono);
        rafDuenos.setDtfecha_registro(dtfecha_registro);
        assertEquals(nmid, rafDuenos.getNmid());
        assertEquals(dsnombre_dueno, rafDuenos.getDsnombre_dueno());
        assertEquals(dstipo_documento, rafDuenos.getDstipo_documento());
        assertEquals(nmidentificacion, rafDuenos.getNmidentificacion());
        assertEquals(dsciudad, rafDuenos.getDsciudad());
        assertEquals(dsdireccion, rafDuenos.getDsdireccion());
        assertEquals(nmtelefono, rafDuenos.getNmtelefono());
        assertEquals(dtfecha_registro, rafDuenos.getDtfecha_registro());
    }
}