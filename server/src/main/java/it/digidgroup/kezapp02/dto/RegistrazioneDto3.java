package it.digidgroup.kezapp02.dto;

import it.digidgroup.kezapp02.model.Chat3;
import it.digidgroup.kezapp02.model.Messaggio3;
import java.util.List;

public class RegistrazioneDto3 {
    private List<Chat3> contatti;
    private List<Messaggio3> messaggi;
    private String sessione;

    public List<Chat3> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat3> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio3> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio3> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
}
