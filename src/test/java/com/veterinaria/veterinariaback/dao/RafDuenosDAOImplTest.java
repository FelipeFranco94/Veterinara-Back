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
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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

/* @Test
    public void testInsert() {
        RafDuenos rafDuenos = new RafDuenos();
        rafDuenos.setNmid(1);
        rafDuenos.setDsnombre_dueno("Hola");
        rafDuenos.setDstipo_documento("C.C.");
        rafDuenos.setNmidentificacion(1L);
        rafDuenos.setDsciudad("Bello");
        rafDuenos.setDsdireccion("Calle 123");
        rafDuenos.setNmtelefono(1L);

        KeyHolder keyHolder = mock(GeneratedKeyHolder.class);
        when(keyHolder.getKey()).thenReturn(1);

        when(jdbcTemplate.update(any(PreparedStatementCreator.class), any(KeyHolder.class)))
                .thenAnswer(invocation -> {
                    PreparedStatementCreator psc = invocation.getArgument(0);
                    psc.createPreparedStatement(mock(Connection.class));
                    return 1;
                });

        RafDuenos insertedDueno = rafDuenosDAO.insert(new RafDuenos());

        assertNotNull(insertedDueno);
        assertEquals(1, insertedDueno.getNmid());
        verify(jdbcTemplate, times(1)).update(any(PreparedStatementCreator.class), any(KeyHolder.class));
    }*/
}