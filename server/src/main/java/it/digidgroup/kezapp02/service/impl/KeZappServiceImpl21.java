package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto21;
import it.digidgroup.kezapp02.dto.RegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto21;
import it.digidgroup.kezapp02.dto.RichiediMessaggiDto21;
import it.digidgroup.kezapp02.model.Chat21;
import it.digidgroup.kezapp02.model.Messaggio21;
import it.digidgroup.kezapp02.repository.ChatRepository21;
import it.digidgroup.kezapp02.repository.MessaggioRepository21;
import it.digidgroup.kezapp02.service.RegistrazioneService21;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl21 implements RegistrazioneService21 {

    @Autowired
    ChatRepository21 cr;
    @Autowired
    MessaggioRepository21 mr;

    @Override
    public RegistrazioneDto21 registrazione(RichiediRegistrazioneDto21 dto) {
        // cerco se esiste già il nickname
        Chat21 chat = cr.findByNickName(dto.getNickName());

        RegistrazioneDto21 dx = new RegistrazioneDto21();
        // se esiste ritorno null, altrimenti lo creo generando l'ID di sessione
        if (chat != null) {
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

    @Override
    public RegistrazioneDto21 inviaAUno(InviaMessaggioDto21 dto) {
        // recupera chat in base alla sessione
        Chat21 chat = cr.findBySessione(dto.getSessione());

        // se la chat non esiste, non ritorna niente
        RegistrazioneDto21 dx = new RegistrazioneDto21();
        if (chat == null) {
            return dx;
        }

        //se il destinatario è indicato, verifico che esista
        if (dto.getDestinatario() != null) {
            Chat21 cdest = cr.findByNickName(dto.getDestinatario());
            if (cdest == null) {
                return dx;
            }
        }

        // se la chat esiste, crea e salva il messaggio
        Messaggio21 msg = new Messaggio21();
        msg.setAliasDestinatario(dto.getDestinatario());
        msg.setAliasMittente(chat.getNickName());
        msg.setTesto(dto.getMessaggio());
        msg = mr.save(msg);

        //ritorna conatti e messaggi aggiornati
        return aggiorna(chat);
    }

    @Override
    public RegistrazioneDto21 inviaTutti(InviaMessaggioDto21 dto) {
        dto.setDestinatario(null);
        return inviaAUno(dto);
    }

    @Override
    public RegistrazioneDto21 aggiorna(RichiediMessaggiDto21 dto) {
        // recupera chat in base alla sessione
        Chat21 chat = cr.findBySessione(dto.getSessione());

        //ritorna conatti e messaggi aggiornati
        return aggiorna(chat);
    }

// recupera i messaggi e i contatti aggiornati
    private RegistrazioneDto21 aggiorna(Chat21 chat) {

        // se la chat non esiste, non ritorna niente
        RegistrazioneDto21 dx = new RegistrazioneDto21();
        if (chat == null) {
            return dx;
        }

        // recupera tutti i contatti
        List<Chat21> contatti = cr.findAll();
        
        // dalla lista di contatti si eliminano i messaggi diretti al nostro nickname
        Stream<Chat21> str = contatti.parallelStream().filter(c-> !(c.getNickName().equals(chat.getNickName())));
        List<Chat21> lista = str.collect(Collectors.toList());
        
        // recupera tutti i messaggi miei e pubblici
        List<Messaggio21> messaggi = mr.trovaMessaggi(chat.getNickName());

        // ritorna il Dto valorizzato
        dx.setContatti(lista);
        dx.setMessaggi(messaggi);
        return dx;
    }
}
