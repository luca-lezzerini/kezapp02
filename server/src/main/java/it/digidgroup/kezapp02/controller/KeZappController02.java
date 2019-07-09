package it.digidgroup.kezapp02.controller;

import it.digidgroup.kezapp02.dto.RegistrazioneDto02;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.digidgroup.kezapp02.service.KeZappService02;

@CrossOrigin("*")
@RestController
public class KeZappController02 {
    @Autowired
    KeZappService02 ks;
    
    @RequestMapping(value = {"/registrazione"})
    @ResponseBody
    RegistrazioneDto02 registrazione(@RequestBody RichiediRegistrazioneDto02 dto){
        
    }
}
