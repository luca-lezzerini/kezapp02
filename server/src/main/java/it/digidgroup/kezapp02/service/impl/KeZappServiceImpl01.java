package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto01;
import it.digidgroup.kezapp02.dto.RegistrazioneDto01;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto01;
import it.digidgroup.kezapp02.model.Chat01;
import it.digidgroup.kezapp02.model.Messaggio01;
import it.digidgroup.kezapp02.repository.ChatRepository01;
import it.digidgroup.kezapp02.repository.MessaggioRepository01;
import it.digidgroup.kezapp02.service.KeZappService01;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl01 implements KeZappService01 {

    @Autowired
    ChatRepository01 cr;
    @Autowired
    MessaggioRepository01 mr;

    @Override
    public RegistrazioneDto01 registrazione(RichiediRegistrazioneDto01 dto) {
        Chat01 chat = cr.findByNickName(dto.getNickName());
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
            dx.setSessione(sessione);
        }

        return dx;
    }

    @Override
    public RegistrazioneDto01 inviaTutti(InviaMessaggioDto01 dto) {
        //recupera chat in base alla sesione
        Chat01 chat = cr.findBySessioned(dto.getSessione());
//se la chat non esiste ritorna niente
        RegistrazioneDto01 dx = new RegistrazioneDto01();
        if (chat == null) {
            return dx;
        }
//se la chat esiste crea e salva il msg
        Messaggio01 msg = new Messaggio01();
        msg.setAliasDestinatario(null);
        msg.setAliasMittente(chat.getNickName());
        msg.setTesto(dto.getMessaggio());
        mr.save(msg);
//recupera tutti i contatti
        List<Chat01> contatti = cr.findAll();
        //recupera tutti i msg miei o pubblici
        List<Messaggio01> messaggi = mr.trovaMessaggi(
                chat.getNickname());
        //ritorna Dto valorizzato
        dx.setContatti(contatti);
        dx.setMessaggi(messaggi);
        return dx;

    }

}
