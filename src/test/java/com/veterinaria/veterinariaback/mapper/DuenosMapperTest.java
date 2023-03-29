package com.veterinaria.veterinariaback.mapper;

import com.veterinaria.veterinariaback.dto.RafDuenos;
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

class DuenosMapperTest {

    @Spy
    @InjectMocks
    private DuenosMapper duenosMapper;

    @Mock
    private ResultSet resultSet;

    @BeforeEach
    public void setup(){
        duenosMapper = new DuenosMapper();
        resultSet = mock(ResultSet.class);
    }

    @Test
    public void testMapRow() throws SQLException {
        Mockito.when(resultSet.getInt("nmid")).thenReturn(1);
        Mockito.when(resultSet.getString("dsnombre_dueno")).thenReturn("dsnombre_dueno");
        Mockito.when(resultSet.getString("dstipo_documento")).thenReturn("dstipo_documento");
        Mockito.when(resultSet.getLong("nmidentificacion")).thenReturn(1L);
        Mockito.when(resultSet.getString("dsciudad")).thenReturn("dsciudad");
        Mockito.when(resultSet.getString("dsdireccion")).thenReturn("dsdireccion");
        Mockito.when(resultSet.getLong("nmtelefono")).thenReturn(1L);
        Mockito.when(resultSet.getDate("dtfecha_registro")).thenReturn(Date.valueOf("2020-06-01"));

        RafDuenos entity = duenosMapper.mapRow(resultSet, 0);

        assertEquals(1, entity.getNmid());
        assertEquals("dsnombre_dueno", entity.getDsnombre_dueno());
        assertEquals("dstipo_documento", entity.getDstipo_documento());
        assertEquals(1L, entity.getNmidentificacion());
        assertEquals("dsciudad", entity.getDsciudad());
        assertEquals("dsdireccion", entity.getDsdireccion());
        assertEquals(1L, entity.getNmtelefono());
    }
}