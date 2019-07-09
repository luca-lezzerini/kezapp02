package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.RegistrazioneDto02;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto02;
import it.digidgroup.kezapp02.model.Chat02;
import it.digidgroup.kezapp02.repository.ChatRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.digidgroup.kezapp02.service.KeZappService02;

@Service
public class KeZappServiceImpl02 implements KeZappService02 {

    @Autowired
    ChatRepository02 cr;

    @Override
    public RegistrazioneDto02 registrazione(RichiediRegistrazioneDto02 dto) {
// cerco nikname
        Chat02 chat = cr.findByNikname(dto.getNickname());

        RegistrazioneDto02 dx = new RegistrazioneDto02();
//se esiste torno sessione null
        if (chat != null) {
            dx.setSessione(null);
        } else {
            Chat02 cx = new Chat02();
            cx.setNikname(dto.getNickname());
            cx = cr.save(cx);
            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);
            dx.setSessione(sessione);
        }
        return dx;
    }
}
