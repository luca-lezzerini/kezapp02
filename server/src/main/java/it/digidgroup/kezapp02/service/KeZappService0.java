package it.digidgroup.kezapp02.service;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto0;
import it.digidgroup.kezapp02.dto.RegistrazioneDto0;
import it.digidgroup.kezapp02.dto.RichiediMessaggiDto;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto0;

public interface KeZappService0 {

    RegistrazioneDto0 registrazione(RichiediRegistrazioneDto0 dto);

    RegistrazioneDto0 inviaTutti(InviaMessaggioDto0 dto);

    RegistrazioneDto0 inviaAUno(InviaMessaggioDto0 dto);

    RegistrazioneDto0 aggiorna(RichiediMessaggiDto dto);
}
