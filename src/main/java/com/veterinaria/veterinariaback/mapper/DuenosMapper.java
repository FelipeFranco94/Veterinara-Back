package com.veterinaria.veterinariaback.mapper;

import com.veterinaria.veterinariaback.dto.RafDuenos;
import com.veterinaria.veterinariaback.util.UtilDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DuenosMapper implements RowMapper<RafDuenos> {

@Override
public RafDuenos mapRow(ResultSet resultSet, int i) throws SQLException{
        RafDuenos entity = new RafDuenos();
        entity.setNmid(resultSet.getInt("nmid"));
        entity.setDsnombre_dueno(resultSet.getString("dsnombre_dueno"));
        entity.setDstipo_documento(resultSet.getString("dstipo_documento"));
        entity.setNmidentificacion(resultSet.getLong("nmidentificacion"));
        entity.setDsciudad(resultSet.getString("dsciudad"));
        entity.setDsdireccion(resultSet.getString("dsdireccion"));
        entity.setNmtelefono(resultSet.getLong("nmtelefono"));
        entity.setDtfecha_registro(UtilDate.getLocalDate(resultSet.getDate("dtfecha_registro")));
        entity.setDuenosFromRs(resultSet);
        return entity;
        }
}
