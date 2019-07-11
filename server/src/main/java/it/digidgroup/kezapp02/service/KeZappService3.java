package it.digidgroup.kezapp02.service;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto3;
import it.digidgroup.kezapp02.dto.RegistrazioneDto3;
import it.digidgroup.kezapp02.dto.RichiediMessaggioDto3;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto3;

public interface KeZappService3 {
    
    RegistrazioneDto3 registrazione(RichiediRegistrazioneDto3 dto);
    
    RegistrazioneDto3 inviaTutti(InviaMessaggioDto3 dto);
    
    RegistrazioneDto3 inviaAUno(InviaMessaggioDto3 dto);
    
    RegistrazioneDto3 aggiorna(RichiediMessaggioDto3 dto);
}
