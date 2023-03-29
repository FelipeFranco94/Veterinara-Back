package com.veterinaria.veterinariaback.service;

import com.veterinaria.veterinariaback.dao.RafMascotaDAO;
import com.veterinaria.veterinariaback.dto.RafMascota;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RafMascotasServiceImpl implements RafMascotasService{

    private final Logger log = LoggerFactory.getLogger(RafMascotasServiceImpl.class);

    private final RafMascotaDAO rafMascotaDAO;

    public RafMascotasServiceImpl(RafMascotaDAO rafMascotaDAO) {
        this.rafMascotaDAO = rafMascotaDAO;
    }


    @Override
    @Transactional(readOnly = true)
    public List<RafMascota> findAll() {
        log.debug("Request to get all rafMascota");
        return rafMascotaDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RafMascota findOne(int nmid_dueno) {
        log.debug("Request to get all rafMascota");
        return rafMascotaDAO.getById(nmid_dueno);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RafMascota>  findOneMascota(int nmid_dueno) {
        log.debug("Request to get all rafMascota");
        return rafMascotaDAO.getByIdMascota(nmid_dueno);
    }

    @Override
    public RafMascota save(RafMascota rafMascota) {
        log.debug("Request to insert rafMascota: {}", rafMascota);
        return rafMascotaDAO.insert(rafMascota);
    }

    @Override
    public RafMascota update(RafMascota rafMascota) {
        log.debug("Request to update rafMascota: {}", rafMascota);
        return rafMascotaDAO.update(rafMascota);
    }
}
