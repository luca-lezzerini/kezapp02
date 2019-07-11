import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegistrazioneDto } from './registrazione-dto';
import { Observable } from 'rxjs';
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
  contatti: Chat[] = [];
  messaggi: Messaggio[] = [];
  messaggio: string;

  constructor(private http: HttpClient) { }

  registrazione() {
    console.log("Siamo in registrazione");
    let ox: Observable<RegistrazioneDto> =
      this.http
        .post<RegistrazioneDto>("http://localhost:8080/registrazione0",
          { nickName: this.nickName });
    ox.subscribe(r => this.sessione = r.sessione);
  }

  inviaTutti() {
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>("http://localhost:8080/inviaTutti0",
        {
          sessione: this.sessione,
          messaggio: this.messaggio,
          destinatario: null
        });
        ox.subscribe( r =>{
          this.contatti = r.contatti;
          this.messaggi = r.messaggi;
        });
  }

  inviaUno(c: Chat) {
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>("http://localhost:8080/inviaUno0",
        {
          sessione: this.sessione,
          messaggio: this.messaggio,
          destinatario: c.nickName
        });
        ox.subscribe( r =>{
          this.contatti = r.contatti;
          this.messaggi = r.messaggi;
        });
  }

}
