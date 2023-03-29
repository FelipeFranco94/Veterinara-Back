package com.veterinaria.veterinariaback.dao;

import com.veterinaria.veterinariaback.dto.RafDuenos;
import com.veterinaria.veterinariaback.mapper.DuenosMapper;
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
class RafDuenosDAOImplTest {


    RafDuenos rafDuenos;

    @InjectMocks
    private RafDuenosDAOImpl rafDuenosDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @BeforeEach
    void init() throws SQLException {
        rafDuenosDAO.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void getAll() {
        List<RafDuenos> duenosList = Arrays.asList(new RafDuenos());
        when(jdbcTemplate.query(anyString(),any(DuenosMapper.class))).thenReturn(duenosList);
        var lista = rafDuenosDAO.getAll();
        assertEquals(1,lista.size());
    }

    @Test
    void update() {
        RafDuenos entity = new RafDuenos();
        when(jdbcTemplate.update(anyString(),any(),any(),any(),any(),any(),any(),any())).thenReturn(0);
        assertNotNull(rafDuenosDAO.update(entity));
    }

    @Test
    void getById() {
        RafDuenos duenos = new RafDuenos();
        when(jdbcTemplate.queryForObject(anyString(),any(DuenosMapper.class),anyInt())).thenReturn(duenos);
        var configuracion = rafDuenosDAO.getById(1);
        assertNotNull(configuracion);
    }

    @Test
    void getByIdExcepcion(){
        when(jdbcTemplate.queryForObject(any(),any(DuenosMapper.class),anyInt())).thenThrow(EmptyResultDataAccessException.class);
        assertNull(rafDuenosDAO.getById(1));
    }
}