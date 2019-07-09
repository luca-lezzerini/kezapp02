package it.digidgroup.kezapp02.dto;

import it.digidgroup.kezapp02.model.Chat0;
import it.digidgroup.kezapp02.model.Messaggio0;
import java.util.List;

public class RegistrazioneDto01 {
    private List<Chat0> contatti;
    private List<Messaggio0> messaggi;
    private String sessione;

    public List<Chat0> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat0> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio0> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio0> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
    
}
