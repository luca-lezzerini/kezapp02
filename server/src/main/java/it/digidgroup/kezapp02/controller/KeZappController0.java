package it.digidgroup.kezapp02.controller;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto0;
import it.digidgroup.kezapp02.dto.RegistrazioneDto0;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto0;
import it.digidgroup.kezapp02.service.KeZappService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KeZappController0 {

    @Autowired
    KeZappService0 ks;

    @RequestMapping(value = {"/registrazione0"})
    @ResponseBody
    RegistrazioneDto0 registrazione(
            @RequestBody RichiediRegistrazioneDto0 dto) {
        return ks.registrazione(dto);
    }

    @RequestMapping(value = {"/inviaTutti0"})
    @ResponseBody
    RegistrazioneDto0 inviaTutti(
            @RequestBody InviaMessaggioDto0 dto) {
        return ks.inviaTutti(dto);
    }
}
