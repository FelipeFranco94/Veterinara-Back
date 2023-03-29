package com.veterinaria.veterinariaback.service;

import com.veterinaria.veterinariaback.dto.RafDuenos;

import java.util.List;

public interface RafDuenosService {
    List<RafDuenos> findAll();
    RafDuenos findOne(int nmid);
    RafDuenos save(RafDuenos rafDuenos);
    RafDuenos update(RafDuenos rafDuenos);
}
