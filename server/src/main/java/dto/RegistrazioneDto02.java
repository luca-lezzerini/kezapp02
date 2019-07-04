package dto;

import it.digidgroup.kezapp02.model.Chat02;
import it.digidgroup.kezapp02.model.Messaggio02;
import static java.util.Collections.list;
import java.util.List;

public class RegistrazioneDto02 {
    private List<Chat02> contatti;
    private List<Messaggio02> messaggi;
    private String sessione;

    public List<Chat02> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat02> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio02> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio02> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
}
