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
public class RafMascota implements Serializable {
    private int nmid ;
    private String dsnombre_mascota;
    private int nmid_especie;
    private String dsraza;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dtfecha_nacimiento;
    private int nmid_dueno;
    private String dsespecie;
    private String dsnombre_dueno;
    @JsonIgnore
    public  void setMascotasFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        dsnombre_mascota = rs.getString("dsnombre_mascota");
        nmid_especie = rs.getInt("nmid_especie");
        dsraza = rs.getString("dsraza");
        dtfecha_nacimiento = UtilDate.getLocalDate(rs.getDate("dtfecha_nacimiento"));
        nmid_dueno = rs.getInt("nmid_dueno");
        dsespecie = rs.getString("dsespecie");
        dsnombre_dueno = rs.getString("dsnombre_dueno");
    }
}


