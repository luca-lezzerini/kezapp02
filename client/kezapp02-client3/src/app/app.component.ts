import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { RegistrazioneDto } from './registrazione-dto';
import { Chat } from './chat';
import { Messaggio } from './messaggio';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  sessione: string;
  nickName: string;
  messaggio: string;
  contatti: Chat[] = [];
  messaggi: Messaggio[] = [];

  constructor(private http: HttpClient){}

  registrazione(){
    console.log("Siamo in registrazione");
    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>
    ("http://localhost:8080/registrazione3",{nickName: this.nickName});
    ox.subscribe( r => {
      this.sessione = r.sessione;
      this.aggiorna();
    });
  }

  inviaTutti(){
    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>
    ("http://localhost:8080/inviaTutti3",
    {sessione: this.sessione, 
     messaggio: this.messaggio,
     destinatario: null });
    ox.subscribe( r => {this.contatti = r.contatti,
                        this.messaggi = r.messaggi});
  }
  
  inviaUno(c: Chat){
    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>
    ("http://localhost:8080/inviaUno3",
    {sessione: this.sessione, 
     messaggio: this.messaggio,
     destinatario: c.nickName });
    ox.subscribe( r => {this.contatti = r.contatti,
                        this.messaggi = r.messaggi});
  }

  aggiorna(){
    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>
    ("http://localhost:8080/aggiorna3",
    {sessione: this.sessione});
    ox.subscribe( r => {this.contatti = r.contatti,
                        this.messaggi = r.messaggi});
  }

}
