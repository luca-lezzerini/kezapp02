package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto02;
import it.digidgroup.kezapp02.dto.RegistrazioneDto02;
import it.digidgroup.kezapp02.dto.RichiediMessaggioDto02;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto02;
import it.digidgroup.kezapp02.model.Chat02;
import it.digidgroup.kezapp02.model.Messaggio02;
import it.digidgroup.kezapp02.repository.ChatRepository02;
import it.digidgroup.kezapp02.repository.MessaggioRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.digidgroup.kezapp02.service.KeZappService02;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KeZappServiceImpl02 implements KeZappService02 {

    @Autowired
    ChatRepository02 cr;

    @Autowired
    MessaggioRepository02 mr;

    @Override
    public RegistrazioneDto02 aggiorna(RichiediMessaggioDto02 dto) {
        // recupera chat in base alla sessione
        Chat02 chat = cr.findBySessione(dto.getSessione());

        // ritorno messaggi e contatti aggiornati
        return aggiorna(chat);
    }

    // recupera i messaggi e i contatti aggiornati
    private RegistrazioneDto02 aggiorna(Chat02 chat) {
        // se la chat non esiste ritorna niente ...
        RegistrazioneDto02 dx = new RegistrazioneDto02();
        if (chat == null) {
            return dx;
        }

        // recupera tutti i contatti
        List<Chat02> contatti = cr.findAll();
//        contatti.parallelStream().filter(c -> !(c.getNickName().equals(chat.getNickName())))
//                .forEach(d -> System.out.println("NickName: " + d.getNickName()));
        Stream<Chat02> str = contatti.parallelStream().filter(c -> !(c.getNickName().equals(chat.getNickName())));
        List<Chat02> lista = str.collect(Collectors.toList());

        // recupera tutti i messaggi miei o pubblici
        List<Messaggio02> messaggi = mr.trovaMessaggi(
                chat.getNickName());

        // ritorna il DTO valorizzato
        dx.setContatti(lista);
        dx.setMessaggi(messaggi);
        return dx;
    }

    @Override
    public RegistrazioneDto02 registrazione(RichiediRegistrazioneDto02 dto) {
// cerco nikname
        Chat02 chat = cr.findByNickName(dto.getNickName());

        RegistrazioneDto02 dx = new RegistrazioneDto02();
//se esiste torno sessione null
        if (chat != null) {
            dx.setSessione(null);
        } else {
            Chat02 cx = new Chat02();
            cx.setNickName(dto.getNickName());
            cx = cr.save(cx);
            String sessione = String.valueOf(cx.getId());
            cx.setSessione(sessione);
            cx = cr.save(cx);
            dx.setSessione(sessione);
        }
        return dx;
    }

    @Override
    public RegistrazioneDto02 inviaAUno(InviaMessaggioDto02 dto) {
        // recupera chat in base alla sessione
        Chat02 chat = cr.findBySessione(dto.getSessione());

        // se la chat non esiste ritorna niente ...
        RegistrazioneDto02 dx = new RegistrazioneDto02();
        if (chat == null) {
            return dx;
        }

        // verifico esistenza destinatario (se necessario, ossia se non nullo)
        if (dto.getDestinatario() != null) {
            Chat02 cdest = cr.findByNickName(dto.getDestinatario());
            if (cdest == null) {
                return dx;
            }
        }

        // ... se la chat esiste, crea e salva il messaggio
        Messaggio02 msg = new Messaggio02();
        msg.setAliasDestinatario(dto.getDestinatario());
        msg.setAliasMittente(chat.getNickName());
        msg.setTesto(dto.getMessaggio());
        msg = mr.save(msg);

        aggiorna(chat);
        /*
        // recupera tutti i contatti
        List<Chat02> contatti = cr.findAll();

        // recupera tutti i messaggi miei o pubblici
        List<Messaggio02> messaggi = mr.trovaMessaggi(
                chat.getNickName());

        // ritorna il DTO valorizzato
        dx.setContatti(contatti);
        dx.setMessaggi(messaggi);
*/
        return dx;
    }

    @Override
    public RegistrazioneDto02 inviaTutti(InviaMessaggioDto02 dto) {
        dto.setDestinatario(null);
        return inviaAUno(dto);
    }
}
