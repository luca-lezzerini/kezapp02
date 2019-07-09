package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.RegistrazioneDto3;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto3;
import it.digidgroup.kezapp02.model.Chat3;
import it.digidgroup.kezapp02.repository.ChatRepository3;
import it.digidgroup.kezapp02.service.KeZappService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl3 implements KeZappService3 {

    @Autowired
    ChatRepository3 cr;

    @Override
    public RegistrazioneDto3 registrazione(RichiediRegistrazioneDto3 dto) {
        //cerco se esiste già il nickname
        Chat3 chat = cr.findByNickname(dto.getNickName());
        //se esiste, ritorno sessione null
        RegistrazioneDto3 dx = new RegistrazioneDto3();
        if ((chat != null)) {
            dx.setSessione(null);
        } //altrimenti lo creo generando l'ID di sessione
        else {
            //salvo la nuova chat
            Chat3 cx = new Chat3();
            cx.setNickname(dto.getNickName());
            cx = cr.save(cx);
            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);
            //creo la nuova sessione
            dx.setSessione(sessione);
        }
        return dx;
    }
}
