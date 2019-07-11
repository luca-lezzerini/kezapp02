package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto01;
import it.digidgroup.kezapp02.dto.RegistrazioneDto0;
import it.digidgroup.kezapp02.dto.RegistrazioneDto01;
import it.digidgroup.kezapp02.dto.RichiediMessaggiDto;
import it.digidgroup.kezapp02.dto.RichiediMessaggioDto01;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto01;
import it.digidgroup.kezapp02.model.Chat0;
import it.digidgroup.kezapp02.model.Chat01;
import it.digidgroup.kezapp02.model.Messaggio0;
import it.digidgroup.kezapp02.model.Messaggio01;
import it.digidgroup.kezapp02.repository.ChatRepository01;
import it.digidgroup.kezapp02.repository.MessaggioRepository01;
import it.digidgroup.kezapp02.service.KeZappService01;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
        // cerco se esiste già il nickname
        Chat01 chat = cr.findByNickName(dto.getNickName());

        // se esiste, ossia chat non nullo, 
        // ritorno sessione null ...
        RegistrazioneDto01 dx = new RegistrazioneDto01();
        if (chat != null) {
            dx.setSessione(null);
        } // ... altrimenti lo creo generando l'ID di sessione
        else {
            // salvo la nuova chat ...
            Chat01 cx = new Chat01();
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
    public RegistrazioneDto01 inviaAUno(InviaMessaggioDto01 dto) {
        //recupera chat in base alla sesione
        Chat01 chat = cr.findBySessione(dto.getSessione());
//se la chat non esiste ritorna niente
        RegistrazioneDto01 dx = new RegistrazioneDto01();
        if (chat == null) {
            return dx;
        }
        if (dto.getDestinatario() != null) {
            Chat01 cdest = cr.findByNickName(dto.getDestinatario());
            if (cdest == null) {
                return dx;
            }
        }
//se la chat esiste crea e salva il msg
        Messaggio01 msg = new Messaggio01();
        msg.setAliasDestinatario(dto.getDestinatario());
        msg.setAliasMittente(chat.getNickName());
        msg.setTesto(dto.getMessaggio());
        mr.save(msg);
//recupera tutti i contatti
        List<Chat01> contatti = cr.findAll();
        //recupera tutti i msg miei o pubblici
        List<Messaggio01> messaggi = mr.trovaMessaggi(
                chat.getNickName());
        //ritorna Dto valorizzato
        dx.setContatti(contatti);
        dx.setMessaggi(messaggi);
        return aggiorna(chat);

    }

    @Override
    public RegistrazioneDto01 inviaTutti(InviaMessaggioDto01 dto) {
        dto.setDestinatario(null);
        return inviaAUno(dto);

    }

     @Override
    public RegistrazioneDto01 aggiorna(RichiediMessaggioDto01 dto) {
        // recupera chat in base alla sessione
        Chat01 chat = cr.findBySessione(dto.getSessione());

        // ritorno messaggi e contatti aggiornati
        return aggiorna(chat);
    }

    // recupera i messaggi e i contatti aggiornati
    private RegistrazioneDto01 aggiorna(Chat01 chat) {
        // se la chat non esiste ritorna niente ...
        RegistrazioneDto01 dx = new RegistrazioneDto01();
        if (chat == null) {
            return dx;
        }

        // recupera tutti i contatti
        List<Chat01> contatti = cr.findAll();
        
       Stream<Chat01> str = contatti.parallelStream()
               .filter(c -> !(c.getNickName().equals(chat.getNickName())));
       List<Chat01> lista = str.collect(Collectors.toList());

        // recupera tutti i messaggi miei o pubblici
        List<Messaggio01> messaggi = mr.trovaMessaggi(
                chat.getNickName());

        // ritorna il DTO valorizzato
        dx.setContatti(lista);
        dx.setMessaggi(messaggi);
        return dx;
    }
}
