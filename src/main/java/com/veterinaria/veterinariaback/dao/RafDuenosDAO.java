package com.veterinaria.veterinariaback.dao;

import com.veterinaria.veterinariaback.dto.RafDuenos;

import java.util.List;

public interface RafDuenosDAO {

    List<RafDuenos> getAll();
    RafDuenos insert(RafDuenos entity);
    RafDuenos update(RafDuenos entity);
    RafDuenos getById(int nmid);
}
