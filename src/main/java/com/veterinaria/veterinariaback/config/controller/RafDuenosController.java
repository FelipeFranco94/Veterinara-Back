package com.veterinaria.veterinariaback.config.controller;

import com.veterinaria.veterinariaback.config.controller.error.ApplicationCustomException;
import com.veterinaria.veterinariaback.dto.RafDuenos;
import com.veterinaria.veterinariaback.service.RafDuenosService;
import com.veterinaria.veterinariaback.util.MessagesConstants;
import com.veterinaria.veterinariaback.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RafDuenosController {

    private Logger log = LoggerFactory.getLogger(RafDuenosController.class);

    private static final String ENITY_NAME = "RafDuenos";

    private final RafDuenosService rafDuenosService;

    public RafDuenosController(RafDuenosService rafDuenosService) {
        this.rafDuenosService = rafDuenosService;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping("/duenos")
    public ResponseEntity<ResponseMessage<List<RafDuenos>>> getAllResponse(){
        log.debug("REST request to save RafDuenos: {}");
        return  ResponseEntity.ok( new ResponseMessage<>(0,null, rafDuenosService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/duenos")
    public ResponseEntity<ResponseMessage<RafDuenos>> createDueno(@Valid @RequestBody RafDuenos rafDuenos) throws ApplicationCustomException {
        log.debug("REST request to save RafDuenos: {}", rafDuenos);
        RafDuenos raf_duenos = rafDuenosService.findOne(rafDuenos.getNmid());
        if(raf_duenos != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        RafDuenos duenos = rafDuenosService.save(rafDuenos);
        return ResponseEntity.ok(new ResponseMessage<>(0,null, duenos));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/duenos")
    public ResponseEntity<ResponseMessage<RafDuenos>> updateDuenos(@Valid @RequestBody RafDuenos rafDuenos) throws ApplicationCustomException{
        log.debug("REST request to update RafDuenos: {}", rafDuenos );
        if(rafDuenos.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        RafDuenos duenos = rafDuenosService.update(rafDuenos);
        return ResponseEntity.ok(new ResponseMessage<>(0,null, duenos));
    }

    @CrossOrigin (origins = "http://localhost:4200")
    @GetMapping("/duenos/{nmid}")
    public ResponseEntity<ResponseMessage<RafDuenos>> getDueno(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get RafDuenos : {}", nmid);
        RafDuenos rafduenos= rafDuenosService.findOne(nmid);
        if(rafduenos == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0,null, rafduenos));
    }
}
