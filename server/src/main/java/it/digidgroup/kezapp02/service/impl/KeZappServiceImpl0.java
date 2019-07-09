package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto0;
import it.digidgroup.kezapp02.dto.RegistrazioneDto0;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto0;
import it.digidgroup.kezapp02.model.Chat0;
import it.digidgroup.kezapp02.model.Messaggio0;
import it.digidgroup.kezapp02.repository.ChatRepository0;
import it.digidgroup.kezapp02.repository.MessaggioRepository0;
import it.digidgroup.kezapp02.service.KeZappService0;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl0 implements KeZappService0 {

    @Autowired
    ChatRepository0 cr;
    @Autowired
    MessaggioRepository0 mr;

    @Override
    public RegistrazioneDto0 registrazione(RichiediRegistrazioneDto0 dto) {
        // cerco se esiste già il nickname
        Chat0 chat = cr.findByNickName(dto.getNickName());

        // se esiste, ossia chat non nullo, 
        // ritorno sessione null ...
        RegistrazioneDto0 dx = new RegistrazioneDto0();
        if (chat != null) {
            dx.setSessione(null);
        } // ... altrimenti lo creo generando l'ID di sessione
        else {
            // salvo la nuova chat ...
            Chat0 cx = new Chat0();
            cx.setNickName(dto.getNickName());
            cx = cr.save(cx);
            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);

            // ... creo la sessione ...
            dx.setSessione(sessione);
        }
        return dx;
    }

    @Override
    public RegistrazioneDto0 inviaTutti(InviaMessaggioDto0 dto) {
        // recupera chat in base alla sessione
        Chat0 chat = cr.findBySessione(dto.getSessione());

        // se la chat non esiste ritorna niente ...
        RegistrazioneDto0 dx = new RegistrazioneDto0();
        if (chat == null) {
            return dx;
        }
        // ... se la chat esiste, crea e salva il messaggio
        Messaggio0 msg = new Messaggio0();
        msg.setAliasDestinatario(null);
        msg.setAliasMittente(chat.getNickName());
        msg.setTesto(dto.getMessaggio());
        msg = mr.save(msg);

        // recupera tutti i contatti
        List<Chat0> contatti = cr.findAll();

        // recupera tutti i messaggi miei o pubblici
        List<Messaggio0> messaggi = mr.trovaMessaggi(
                chat.getNickName());

        // ritorna il DTO valorizzato
        dx.setContatti(contatti);
        dx.setMessaggi(messaggi);
        return dx;
    }

}
