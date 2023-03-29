package com.veterinaria.veterinariaback.dao;

import com.veterinaria.veterinariaback.dto.RafMascota;
import com.veterinaria.veterinariaback.mapper.RafMascotaMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RafMascotaDAOImplTest {

    RafMascota rafMascota;

    @InjectMocks
    private RafMascotaDAOImpl  rafMascotaDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @BeforeEach
    void init() throws SQLException {
        rafMascotaDAO.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void getAll() {
        List<RafMascota> mascotaList = Arrays.asList(new RafMascota());
        when(jdbcTemplate.query(anyString(),any(RafMascotaMapper.class))).thenReturn(mascotaList);
        var lista = rafMascotaDAO.getAll();
        assertEquals(1,lista.size());
    }

    @Test
    void update() {
        RafMascota mascota = new RafMascota();
        when(jdbcTemplate.update(anyString(),any(),any(),any(),any(),any(),any())).thenReturn(0);
        assertNotNull(rafMascotaDAO.update(mascota));
    }

    @Test
    void getById() {
        RafMascota mascota = new RafMascota();
        when(jdbcTemplate.queryForObject(anyString(),any(RafMascotaMapper.class),anyInt())).thenReturn(mascota);
        var configuracion = rafMascotaDAO.getById(1);
        assertNotNull(configuracion);
    }

    @Test
    void getByIdExcepcion(){
        when(jdbcTemplate.queryForObject(any(),any(RafMascotaMapper.class),anyInt())).thenThrow(EmptyResultDataAccessException.class);
        assertNull(rafMascotaDAO.getById(1));
    }

    @Test
    void getByIdMascota() {
        List<RafMascota> mascotaList = Arrays.asList(new RafMascota());
        when(jdbcTemplate.query(anyString(),any(RafMascotaMapper.class),anyInt())).thenReturn(mascotaList);
        var configuracion = rafMascotaDAO.getByIdMascota(1);
        assertNotNull(configuracion);
    }

    @Test
    void getByIdMascotaExcepcion() {
        when(jdbcTemplate.query(any(),any(RafMascotaMapper.class),anyInt())).thenThrow(EmptyResultDataAccessException.class);
        assertNull(rafMascotaDAO.getByIdMascota(1));
    }
}