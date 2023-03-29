package com.veterinaria.veterinariaback.dao;

import com.veterinaria.veterinariaback.dto.RafMascota;
import com.veterinaria.veterinariaback.mapper.RafMascotaMapper;
import com.veterinaria.veterinariaback.util.DaoUtil;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RafMascotaDAOImpl implements RafMascotaDAO{

    private static final String SELECT = " SELECT m.nmid, m.dsnombre_mascota, m.nmid_especie, m.dsraza, m.dtfecha_nacimiento, m.nmid_dueno, d.dsnombre_dueno, es.dsespecie FROM mascotas m INNER JOIN duenos_mascotas d ON m.nmid_dueno = d.nmid INNER JOIN especie es ON m.nmid_especie = es.nmid ";
    private static final String INSERT = " INSERT INTO mascotas(nmid, dsnombre_mascota, nmid_especie, dsraza, dtfecha_nacimiento, nmid_dueno) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = " UPDATE mascotas SET dsnombre_mascota=?, nmid_especie=?, dsraza=?, dtfecha_nacimiento=?, nmid_dueno=? WHERE nmid=? ";
    private static final String SELECTBYID = SELECT + " WHERE nmid_dueno = ?";

    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public RafMascotaDAOImpl(DataSource dataSource){ jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<RafMascota> getAll() {
        return jdbcTemplate.query(SELECT , new RafMascotaMapper());
    }

    @Override
    public RafMascota insert(RafMascota entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{ "nmid" });
            DaoUtil.setPrepareStatement(ps,
                    new Object[]{
                            entity.getNmid(),
                            entity.getDsnombre_mascota(),
                            entity.getNmid_especie(),
                            entity.getDsraza(),
                            entity.getDtfecha_nacimiento(),
                            entity.getNmid_dueno()
                    });
            return ps;
        }, keyHolder);
        entity.setNmid(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public RafMascota update(RafMascota entity) {
        jdbcTemplate.update(UPDATE,
                entity.getDsnombre_mascota(),
                entity.getNmid_especie(),
                entity.getDsraza(),
                entity.getDtfecha_nacimiento(),
                entity.getNmid_dueno(),
                entity.getNmid()
        );
        return entity;
    }

    @Override
    public RafMascota getById(int nmid_dueno) {
        try {
            return  jdbcTemplate.queryForObject(SELECTBYID, new RafMascotaMapper(), nmid_dueno);
        }
        catch (EmptyResultDataAccessException ex){
            return null;
        }
    }
    @Override
    public List<RafMascota> getByIdMascota(int nmid_dueno) {
        try {
            return  jdbcTemplate.query(SELECTBYID, new RafMascotaMapper(), nmid_dueno);
        }
        catch (EmptyResultDataAccessException ex){
            return null;
        }
    }
}
