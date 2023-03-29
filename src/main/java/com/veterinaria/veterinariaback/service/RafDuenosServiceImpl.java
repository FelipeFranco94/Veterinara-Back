package com.veterinaria.veterinariaback.service;

import com.veterinaria.veterinariaback.dao.RafDuenosDAO;
import com.veterinaria.veterinariaback.dto.RafDuenos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RafDuenosServiceImpl  implements RafDuenosService {

    private final Logger log = LoggerFactory.getLogger(RafDuenosServiceImpl.class);

    private final RafDuenosDAO rafDuenosDAO;

    public RafDuenosServiceImpl(RafDuenosDAO rafDuenosDAO) {
        this.rafDuenosDAO = rafDuenosDAO;
    }

    @Override
    public RafDuenos save(RafDuenos rafDuenos) {
        log.debug("Request to insert rafDuenos: {}", rafDuenos);
        return rafDuenosDAO.insert(rafDuenos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RafDuenos> findAll() {
        log.debug("Request to get all rafDuenos");
        return rafDuenosDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RafDuenos findOne(int nmid) {
        log.debug("Request to get all rafDuenos");
        return rafDuenosDAO.getById(nmid);
    }

    @Override
    public RafDuenos update(RafDuenos rafDuenos) {
        log.debug("Request to update rafDuenos: {}", rafDuenos);
        return rafDuenosDAO.update(rafDuenos);
    }
}
