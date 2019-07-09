package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.RegistrazioneDto01;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto01;
import it.digidgroup.kezapp02.model.Chat01;
import it.digidgroup.kezapp02.repository.ChatRepository01;
import it.digidgroup.kezapp02.service.KeZappService01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl01 implements KeZappService01 {

    @Autowired
    ChatRepository01 cr;

    @Override
    public RegistrazioneDto01 registrazione(RichiediRegistrazioneDto01 dto) {
        Chat01 chat = cr.findByNickname(dto.getNickName());
        //Cerco se esiste già nickname
        RegistrazioneDto01 dx = new RegistrazioneDto01();
        if (chat != null) {
            dx.setSessione(null);
           

        } //se esiste ritorno null altrimenti lo creo generando id di sessione
        else {
            Chat01 cx = new Chat01();
            cx.setNickname(dto.getNickName());
            cx = cr.save(cx);

            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);

        }
       
        return dx;
    }

}
