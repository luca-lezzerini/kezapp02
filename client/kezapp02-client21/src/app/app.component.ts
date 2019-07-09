import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistrazioneDto } from './registrazione-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  sessione: string;
  nickName: string;

  constructor(private http: HttpClient){}

  registrazione(){
    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>("http://localhost:8080/registrazione21",{nickname: this.nickName})
    ox.subscribe (r => this.sessione = r.sessione);
  }

  inviaTutti(){
    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>("http://localhost:8080/inviatutti21",{nickname: this.nickName})
    ox.subscribe (r => this.sessione = r.sessione);
  }
}
