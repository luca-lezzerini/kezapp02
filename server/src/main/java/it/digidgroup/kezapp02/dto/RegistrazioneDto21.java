
package it.digidgroup.kezapp02.dto;

import it.digidgroup.kezapp02.model.Chat21;
import it.digidgroup.kezapp02.model.Messaggio21;
import java.util.List;

public class RegistrazioneDto21 {
    private List<Chat21> contatti;
    private List<Messaggio21> messaggi;
    private String sessione;

    public List<Chat21> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat21> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio21> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio21> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
}
