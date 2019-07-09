package it.digidgroup.kezapp02.controller;

import it.digidgroup.kezapp02.dto.RegistrazioneDto3;
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
}
