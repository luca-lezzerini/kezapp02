package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.RegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto21;
import it.digidgroup.kezapp02.model.Chat21;
import it.digidgroup.kezapp02.repository.ChatRepository21;
import it.digidgroup.kezapp02.service.RegistrazioneService21;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl21 implements RegistrazioneService21{

    @Autowired
    ChatRepository21 cr;
    
    @Override
    public RegistrazioneDto21 registrazione(RichiediRegistrazioneDto21 dto) {
        // cerco se esiste già il nickname
        Chat21 chat = cr.findByNickName(dto.getNickName());

        RegistrazioneDto21 dx = new RegistrazioneDto21();
        // se esiste ritorno null, altrimenti lo creo generando l'ID di sessione
        if (chat != null){
            dx.setSessione(null);
        } else {
            // salvo la nuova chat
            Chat21 cx = new Chat21();
            cx.setNickName(dto.getNickName());
            cx = cr.save(cx);
            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);
            
            // creo la sessione
            dx.setSessione(sessione);
        }
        return dx;
    }
    
}
