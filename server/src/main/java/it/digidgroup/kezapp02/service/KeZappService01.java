package it.digidgroup.kezapp02.service;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto01;
import it.digidgroup.kezapp02.dto.RegistrazioneDto01;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto01;

public interface KeZappService01 {

    RegistrazioneDto01 registrazione(RichiediRegistrazioneDto01 dto);
    RegistrazioneDto01 inviaTutti(InviaMessaggioDto01 dto);
}
