package com.veterinaria.veterinariaback.mapper;

import com.veterinaria.veterinariaback.dto.RafMascota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class RafMascotaMapperTest {

    RafMascota rafMascota;
    @Spy
    @InjectMocks
    private RafMascotaMapper rafMascotaMapper;

    @Mock
    private ResultSet resultSet;

    @BeforeEach
    public void setup(){
        rafMascotaMapper = new RafMascotaMapper();
        resultSet = mock(ResultSet.class);
    }

    @Test
    public void testMapRow() throws SQLException {
        Mockito.when(resultSet.getInt("nmid")).thenReturn(1);
        Mockito.when(resultSet.getString("dsnombre_mascota")).thenReturn("dsnombre_mascota");
        Mockito.when(resultSet.getInt("nmid_especie")).thenReturn(1);
        Mockito.when(resultSet.getString("dsraza")).thenReturn("dsraza");
        Mockito.when(resultSet.getDate("dtfecha_nacimiento")).thenReturn(Date.valueOf("2020-06-01"));
        Mockito.when(resultSet.getInt("nmid_dueno")).thenReturn(1);
        Mockito.when(resultSet.getString("dsespecie")).thenReturn("dsespecie");

        RafMascota entity = rafMascotaMapper.mapRow(resultSet, 0);

        assertEquals(1, entity.getNmid());
        assertEquals("dsnombre_mascota", entity.getDsnombre_mascota());
        assertEquals(1, entity.getNmid_especie());
        assertEquals("dsraza", entity.getDsraza());
        assertEquals(1, entity.getNmid_dueno());
        assertEquals("dsespecie", entity.getDsespecie());
    }
}