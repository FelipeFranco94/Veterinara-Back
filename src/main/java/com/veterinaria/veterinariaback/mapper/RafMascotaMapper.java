package com.veterinaria.veterinariaback.mapper;

import com.veterinaria.veterinariaback.dto.RafMascota;
import com.veterinaria.veterinariaback.util.UtilDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RafMascotaMapper implements RowMapper<RafMascota> {

    @Override
    public RafMascota mapRow(ResultSet resultSet, int i) throws SQLException {
        RafMascota entity = new RafMascota();
        entity.setNmid(resultSet.getInt("nmid"));
        entity.setDsnombre_mascota(resultSet.getString("dsnombre_mascota"));
        entity.setNmid_especie(resultSet.getInt("nmid_especie"));
        entity.setDsraza(resultSet.getString("dsraza"));
        entity.setDtfecha_nacimiento(UtilDate.getLocalDate(resultSet.getDate("dtfecha_nacimiento")));
        entity.setNmid_dueno(resultSet.getInt("nmid_dueno"));
        entity.setDsespecie(resultSet.getString("dsespecie"));
        entity.setDsnombre_dueno(resultSet.getString("dsnombre_dueno"));
        entity.setMascotasFromRs(resultSet);
        return entity;
    }
}
