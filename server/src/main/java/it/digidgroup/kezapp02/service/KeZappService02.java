package it.digidgroup.kezapp02.service;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto02;
import it.digidgroup.kezapp02.dto.RegistrazioneDto02;
import it.digidgroup.kezapp02.dto.RichiediMessaggioDto02;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto02;

public interface KeZappService02 {
    RegistrazioneDto02 registrazione(RichiediRegistrazioneDto02 dto);
    RegistrazioneDto02 inviaTutti(InviaMessaggioDto02 dto);
    RegistrazioneDto02 inviaAUno(InviaMessaggioDto02 dto);
    RegistrazioneDto02 aggiorna(RichiediMessaggioDto02 dto);
}
