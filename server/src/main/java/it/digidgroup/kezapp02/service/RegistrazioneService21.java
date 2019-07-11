
package it.digidgroup.kezapp02.service;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto21;
import it.digidgroup.kezapp02.dto.RegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediMessaggiDto21;

public interface RegistrazioneService21 {
    RegistrazioneDto21 registrazione(RichiediRegistrazioneDto21 dto);
    RegistrazioneDto21 inviaTutti(InviaMessaggioDto21 dto);
    RegistrazioneDto21 inviaAUno(InviaMessaggioDto21 dto);
    RegistrazioneDto21 aggiorna(RichiediMessaggiDto21 dto);
}
