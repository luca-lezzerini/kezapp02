package it.digidgroup.kezapp02.controller;

import it.digidgroup.kezapp02.dto.RegistrazioneDto01;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto01;
import it.digidgroup.kezapp02.service.KeZappService01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KeZappController01 {

    @Autowired
    KeZappService01 ks;
    
    @RequestMapping(value = {"/registrazione01"})
    @ResponseBody
    RegistrazioneDto01   registrazione(
            @RequestBody RichiediRegistrazioneDto01 dto) {
return ks.registrazione(dto);
    }
}
