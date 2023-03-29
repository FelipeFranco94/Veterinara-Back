package com.veterinaria.veterinariaback.dao;

import com.veterinaria.veterinariaback.dto.RafDuenos;
import com.veterinaria.veterinariaback.mapper.DuenosMapper;
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
public class RafDuenosDAOImpl implements RafDuenosDAO {

    private static final String SELECT = " SELECT * FROM `duenos_mascotas` ";

    private static final String INSERT = " INSERT INTO duenos_mascotas (nmid, dsnombre_dueno, dstipo_documento, nmidentificacion, dsciudad, dsdireccion, nmtelefono, dtfecha_registro) VALUES (?,?,?,?,?,?,?, now())";

    private static final String UPDATE = " UPDATE `duenos_mascotas` SET `dsnombre_dueno`=?,`dstipo_documento`=?,`nmidentificacion`=?,`dsciudad`=?,`dsdireccion`=?,`nmtelefono`=?  WHERE `nmid`=?";

    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public RafDuenosDAOImpl(DataSource dataSource){ jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<RafDuenos> getAll() {
        return jdbcTemplate.query(SELECT, new DuenosMapper());
    }

    @Override
    public RafDuenos insert(RafDuenos entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{ "nmid" });
            DaoUtil.setPrepareStatement(ps,
                    new Object[]{
                            entity.getNmid(),
                            entity.getDsnombre_dueno(),
                            entity.getDstipo_documento(),
                            entity.getNmidentificacion(),
                            entity.getDsciudad(),
                            entity.getDsdireccion(),
                            entity.getNmtelefono()
                    });
            return ps;
        }, keyHolder);
        entity.setNmid(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public RafDuenos update(RafDuenos entity) {
        jdbcTemplate.update(UPDATE,
                entity.getDsnombre_dueno(),
                entity.getDstipo_documento(),
                entity.getNmidentificacion(),
                entity.getDsciudad(),
                entity.getDsdireccion(),
                entity.getNmtelefono(),
                entity.getNmid()
                );
        return entity;
    }

    @Override
    public RafDuenos getById(int nmid) {
        try {
            return  jdbcTemplate.queryForObject(SELECTBYID, new DuenosMapper(), nmid);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }
}
