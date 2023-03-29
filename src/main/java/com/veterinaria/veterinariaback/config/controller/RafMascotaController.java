package com.veterinaria.veterinariaback.config.controller;

import com.veterinaria.veterinariaback.config.controller.error.ApplicationCustomException;
import com.veterinaria.veterinariaback.dto.RafMascota;
import com.veterinaria.veterinariaback.service.RafMascotasService;
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
public class RafMascotaController {

    private Logger log = LoggerFactory.getLogger(RafMascotaController.class);

    private static final String ENITY_NAME = "RafMascotas";

    private final RafMascotasService rafMascotasService;

    public RafMascotaController(RafMascotasService rafMascotasService) {
        this.rafMascotasService = rafMascotasService;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping("/mascotas")
    public ResponseEntity<ResponseMessage<List<RafMascota>>> getAllResponse(){
        log.debug("REST request to save RafMascotas: {}");
        return  ResponseEntity.ok( new ResponseMessage<>(0,null, rafMascotasService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/mascotas")
    public ResponseEntity<ResponseMessage<RafMascota>> createMascotas(@Valid @RequestBody RafMascota rafMascota) throws ApplicationCustomException {
        log.debug("REST request to save RafMascotas: {}", rafMascota);
        RafMascota raf_mascota = rafMascotasService.findOne(rafMascota.getNmid());
        if(raf_mascota != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        RafMascota mascota = rafMascotasService.save(rafMascota);
        return ResponseEntity.ok(new ResponseMessage<>(0,null, mascota));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/mascotas")
    public ResponseEntity<ResponseMessage<RafMascota>> updateMascotas(@Valid @RequestBody RafMascota rafMascota) throws ApplicationCustomException{
        log.debug("REST request to update RafMascotas: {}", rafMascota );
        if(rafMascota.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        RafMascota mascota = rafMascotasService.update(rafMascota);
        return ResponseEntity.ok(new ResponseMessage<>(0,null, mascota));
    }

    @CrossOrigin (origins = "http://localhost:4200")
    @GetMapping("/mascotas/{nmid_dueno}")
    public  ResponseEntity<ResponseMessage<List<RafMascota>>>  getMascotas(@PathVariable int nmid_dueno) throws ApplicationCustomException{
        log.debug("REST request to get RafMascotas : {}", nmid_dueno);
        List<RafMascota> rafMascota= rafMascotasService.findOneMascota(nmid_dueno);
        if (rafMascota == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0,null, rafMascota));
    }
}
