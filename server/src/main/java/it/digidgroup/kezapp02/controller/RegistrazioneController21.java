package it.digidgroup.kezapp02.controller;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto21;
import it.digidgroup.kezapp02.dto.RegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediMessaggiDto21;
import it.digidgroup.kezapp02.service.RegistrazioneService21;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RegistrazioneController21 {
    
    @Autowired
    RegistrazioneService21 ks;
    
    @RequestMapping(value = {"/registrazione21"})
    @ResponseBody
    RegistrazioneDto21 registrazione(@RequestBody RichiediRegistrazioneDto21 dto){
        return ks.registrazione(dto);
    }
    
    @RequestMapping(value = {"/inviaTutti21"})
    @ResponseBody
    RegistrazioneDto21 inviaTutti(@RequestBody InviaMessaggioDto21 dto){
        return ks.inviaTutti(dto);
    }
    
    @RequestMapping(value = {"/inviaUno21"})
    @ResponseBody
    RegistrazioneDto21 inviaUno(@RequestBody InviaMessaggioDto21 dto){
        return ks.inviaAUno(dto);
    }

    @RequestMapping(value = {"/aggiorna21"})
    @ResponseBody
    RegistrazioneDto21 aggiorna(@RequestBody RichiediMessaggiDto21 dto){
        return ks.aggiorna(dto);
    }    
}
