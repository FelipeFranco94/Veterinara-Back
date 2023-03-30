package com.veterinaria.veterinariaback.util;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DaoUtilTest {

    @InjectMocks
    private DaoUtil daoUtil;


    @Test
    void setPrepareStatementTest() throws SQLException {
        Connection connection = mock(Connection.class);
        PreparedStatement statement = mock(PreparedStatement.class);

        Object[] data = {1, "test", 1};
        DaoUtil.setPrepareStatement(statement, data);
        verify(statement, times(1)).setInt(1, 1);

    }

    @Test
    void getDoubleMapperTest() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getObject("column")).thenReturn(1);
        Double result = DaoUtil.getDoubleMapper(resultSet, "column");
        assertNotNull(result);
    }

    @Test
    void getStringTest() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.getString("column")).thenReturn("test");
        String result = DaoUtil.getString(mockResultSet, "column");
        assertEquals("test", result);
    }

    @Test
    void getLongTest() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.getLong("column")).thenReturn(1L);
        long result = DaoUtil.getLong(mockResultSet, "column");
        assertEquals(1L, result);
    }

    @Test
    void getDoubleTest() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);

        when(mockResultSet.getDouble("column")).thenReturn(3.0);

        double result = DaoUtil.getDouble(mockResultSet, "column");

        assertEquals(3.0, result);
    }
}