package com.veterinaria.veterinariaback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.veterinaria.veterinariaback.util.UtilDate;
import lombok.Data;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
public class RafDuenos implements Serializable {
    private int nmid;
    private String dsnombre_dueno;
    private String dstipo_documento;
    private Long nmidentificacion;
    private String dsciudad;
    private String dsdireccion;
    private Long nmtelefono;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dtfecha_registro;

    @JsonIgnore
    public  void setDuenosFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        dsnombre_dueno = rs.getString("dsnombre_dueno");
        dstipo_documento = rs.getString("dstipo_documento");
        nmidentificacion = rs.getLong("nmidentificacion");
        dsciudad = rs.getString("dsciudad");
        dsdireccion = rs.getString("dsdireccion");
        nmtelefono = rs.getLong("nmtelefono");
        dtfecha_registro = UtilDate.getLocalDate(rs.getDate("dtfecha_registro"));
    }
}
