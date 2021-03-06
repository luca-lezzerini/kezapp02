package it.digidgroup.kezapp02.controller;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto3;
import it.digidgroup.kezapp02.dto.RegistrazioneDto3;
import it.digidgroup.kezapp02.dto.RichiediMessaggioDto3;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto3;
import it.digidgroup.kezapp02.service.KeZappService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KeZappController3 {

    @Autowired
    KeZappService3 ks;

    @RequestMapping(value = {"/registrazione3"})
    @ResponseBody
    RegistrazioneDto3 registrazione(
            @RequestBody RichiediRegistrazioneDto3 dto) {
        return ks.registrazione(dto);
    }
    
    @RequestMapping(value = {"/inviaTutti3"})
    @ResponseBody
    RegistrazioneDto3 inviaTutti(
            @RequestBody InviaMessaggioDto3 dto) {
        return ks.inviaTutti(dto);
    }
    
    @RequestMapping(value = {"/inviaUno3"})
    @ResponseBody
    RegistrazioneDto3 inviaUno(
            @RequestBody InviaMessaggioDto3 dto) {
        return ks.inviaAUno(dto);
    }
    
    @RequestMapping(value = {"/aggiorna3"})
    @ResponseBody
    RegistrazioneDto3 aggiorna (
            @RequestBody RichiediMessaggioDto3 dto) {
        return ks.aggiorna(dto);
    }
}
