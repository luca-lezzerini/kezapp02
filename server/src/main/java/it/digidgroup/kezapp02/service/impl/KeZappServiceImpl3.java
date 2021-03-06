package it.digidgroup.kezapp02.service.impl;

import it.digidgroup.kezapp02.dto.InviaMessaggioDto3;
import it.digidgroup.kezapp02.dto.RegistrazioneDto3;
import it.digidgroup.kezapp02.dto.RichiediMessaggioDto3;
import it.digidgroup.kezapp02.dto.RichiediRegistrazioneDto3;
import it.digidgroup.kezapp02.model.Chat3;
import it.digidgroup.kezapp02.model.Messaggio3;
import it.digidgroup.kezapp02.repository.ChatRepository3;
import it.digidgroup.kezapp02.repository.MessaggioRepository3;
import it.digidgroup.kezapp02.service.KeZappService3;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeZappServiceImpl3 implements KeZappService3 {

    @Autowired
    ChatRepository3 cr;
    
    @Autowired
    MessaggioRepository3 mr;

    @Override
    public RegistrazioneDto3 registrazione(RichiediRegistrazioneDto3 dto) {
        //cerco se esiste già il nickname
        Chat3 chat = cr.findByNickName(dto.getNickName());
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

    @Override
    public RegistrazioneDto3 inviaAUno(InviaMessaggioDto3 dto) {
        //recupero chat in base alla sessione
        Chat3 chat = cr.findBySessione(dto.getSessione());
        //se la chat non esiste ritorna niente
        RegistrazioneDto3 dx = new RegistrazioneDto3();
        if ((chat == null)) {
            return dx;
        }
        //veerifico esistenza destinatario (se necessario, ossia non nullo)
        if(dto.getDestinatario() != null){
            Chat3 cdest = cr.findByNickName(dto.getDestinatario());
            if (cdest == null){
                return dx;
            }
        }
        //se la chat esiste crea e salva il messaggio
        Messaggio3 msg = new Messaggio3();
        msg.setAliasDestinatario(dto.getDestinatario());
        msg.setAliasMittente(chat.getNickname());
        msg.setTesto(dto.getMessaggio());
        msg = mr.save(msg);
              
        return aggiorna(chat);
    }
    
    @Override
    public RegistrazioneDto3 inviaTutti(InviaMessaggioDto3 dto) {
        dto.setDestinatario(null);
        return inviaAUno(dto);
    }
    
    @Override
    public RegistrazioneDto3 aggiorna(RichiediMessaggioDto3 dto) {
        //recupero chat in base alla sessione
        Chat3 chat = cr.findBySessione(dto.getSessione());
        //Aggiorno la chat
        return aggiorna(chat);
    }
    
    private RegistrazioneDto3 aggiorna(Chat3 chat) {
       
        RegistrazioneDto3 dx = new RegistrazioneDto3();
       
        if ((chat == null)) {
            return dx;
        }
        // recupera tutti i contatti
        List<Chat3> contatti = cr.findAll();
        //rimuovo me stesso
        Stream<Chat3> str = contatti.parallelStream()
                .filter(c -> !(c.getNickname().equals(chat.getNickname())));
        List<Chat3> lista = str.collect(Collectors.toList());
        
        // recupera tutti i messaggi miei o pubblici
        List<Messaggio3> messaggi = mr.trovaMessaggi(chat.getNickname());
        // ritorna il DTO valorizzato
        dx.setContatti(lista);
        dx.setMessaggi(messaggi);
        return dx;
    }
}
