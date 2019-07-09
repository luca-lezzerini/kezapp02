package it.digidgroup.kezapp02.dto;

import it.digidgroup.kezapp02.model.Chat01;
import it.digidgroup.kezapp02.model.Messaggio0;
import it.digidgroup.kezapp02.model.Messaggio01;
import java.util.List;

public class RegistrazioneDto01 {
    private List<Chat01> contatti;
    private List<Messaggio01> messaggi;
    private String sessione;

    public List<Chat01> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat01> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio01> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio01> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
    
}
