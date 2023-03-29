package com.veterinaria.veterinariaback.dao;

import com.veterinaria.veterinariaback.dto.RafMascota;

import java.util.List;

public interface RafMascotaDAO {

    List<RafMascota> getAll();
    RafMascota insert(RafMascota entity);
    RafMascota update(RafMascota entity);
    RafMascota getById(int nmid_dueno);
    List<RafMascota> getByIdMascota(int nmid_dueno);
}
