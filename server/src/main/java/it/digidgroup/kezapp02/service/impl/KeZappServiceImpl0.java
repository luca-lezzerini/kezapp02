package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.RegistrazioneDto0;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto0;
import it.digidgroup.kezapp02.model.Chat0;
import it.digidgroup.kezapp02.repository.ChatRepository0;
import it.digidgroup.kezapp02.service.KeZappService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl0 implements KeZappService0 {

    @Autowired
    ChatRepository0 cr;

    @Override
    public RegistrazioneDto0 registrazione(RichiediRegistrazioneDto0 dto) {
        // cerco se esiste già il nickname
        Chat0 chat = cr.findByNickname(dto.getNickName());

        // se esiste, ossia chat non nullo, 
        // ritorno sessione null ...
        RegistrazioneDto0 dx = new RegistrazioneDto0();
        if (chat != null) {
            dx.setSessione(null);
        } // ... altrimenti lo creo generando l'ID di sessione
        else {
            // salvo la nuova chat ...
            Chat0 cx = new Chat0();
            cx.setNickname(dto.getNickName());
            cx = cr.save(cx);
            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);

            // ... creo la sessione ...
            dx.setSessione(sessione);
        }
        return dx;
    }
}
