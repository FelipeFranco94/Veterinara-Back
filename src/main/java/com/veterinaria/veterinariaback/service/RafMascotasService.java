package com.veterinaria.veterinariaback.service;

import com.veterinaria.veterinariaback.dto.RafMascota;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RafMascotasService {
    List<RafMascota> findAll();
    @Transactional(readOnly = true)
    RafMascota findOne(int nmid_dueno);
    RafMascota save(RafMascota rafMascota);
    RafMascota update(RafMascota rafMascota);

    List<RafMascota> findOneMascota(int nmid_dueno);
}
