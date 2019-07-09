package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto02;
import it.digidgroup.kezapp02.dto.RegistrazioneDto02;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto02;
import it.digidgroup.kezapp02.model.Chat02;
import it.digidgroup.kezapp02.model.Messaggio02;
import it.digidgroup.kezapp02.repository.ChatRepository02;
import it.digidgroup.kezapp02.repository.MessaggioRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.digidgroup.kezapp02.service.KeZappService02;
import java.util.List;

@Service
public class KeZappServiceImpl02 implements KeZappService02 {

    @Autowired
    ChatRepository02 cr;

    @Autowired
    MessaggioRepository02 mr;

    @Override
    public RegistrazioneDto02 registrazione(RichiediRegistrazioneDto02 dto) {
// cerco nikname
        Chat02 chat = cr.findByNikname(dto.getNikname());

        RegistrazioneDto02 dx = new RegistrazioneDto02();
//se esiste torno sessione null
        if (chat != null) {
            dx.setSessione(null);
        } else {
            Chat02 cx = new Chat02();
            cx.setNikname(dto.getNikname());
            cx = cr.save(cx);
            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);
            dx.setSessione(sessione);
        }
        return dx;
    }

    @Override
    public RegistrazioneDto02 inviaTutti(InviaMessaggioDto02 dto) {
        RegistrazioneDto02 dx = new RegistrazioneDto02();
        // recupera chat da sessione
        Chat02 chat = cr.findBySessione(dto.getSessione());
        // se non chat return null
        if (chat != null){
        // se chat esiste crea e salva messaggio
            Messaggio02 mess = new Messaggio02();
            mess.setAliasDestinatario(null);
            mess.setAliasMittente(chat.getNikname());
            mess.setTesto(dto.getMessaggio());
            mess = mr.save(mess);
        // recupera tutti i contatti
            List<Chat02> listaChat = cr.findAll();
        // recupera tutti i messaggi (miei o pubblici)
            List<Messaggio02> listaMess = mr.trovaMessaggi(chat.getNikname());
        // return dto
            dx.setContatti(listaChat);
            dx.setMessaggi(listaMess);
        }
        return dx;
    }
}
