package it.digidgroup.kezapp02.controller;

import it.digidgroup.kezapp02.dto.RegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto21;
import it.digidgroup.kezapp02.service.RegistrazioneService21;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RegistrazioneController21 {
    
    @Autowired
    RegistrazioneService21 ks;
    
    @RequestMapping(value = {"/registrazione21"})
    @ResponseBody
    RegistrazioneDto21 registrazione(@RequestBody RichiediRegistrazioneDto21 dto){
        return ks.registrazione(dto);
    }
}
