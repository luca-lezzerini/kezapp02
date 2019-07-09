import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistrazioneDto } from './registrazione-dto';
import { Messaggio } from './messaggio';
import { Chat } from './chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  sessione: string;
  nickName: string;
  contatti: Chat[]=[];
  messaggi: Messaggio[]=[];
  messaggio: string;

  constructor(private http: HttpClient){}

  registrazione(){
    let ox: Observable<RegistrazioneDto> =
       this.http.post<RegistrazioneDto>("http://localhost:8080/registrazione02",
                                        {nickName:this.nickName});
    ox.subscribe(r => this.sessione = r.sessione);
  }

  inviaTutti() {
    let ox: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>("http://localhost:8080/inviaTutti02",
                                                                              {sessione: this.sessione,
                                                                               messaggio: this.messaggio,
                                                                               destinatario: null});
    ox.subscribe(r => {this.contatti = r.contatti;
                       this.messaggi = r.messaggi});
  }

}
