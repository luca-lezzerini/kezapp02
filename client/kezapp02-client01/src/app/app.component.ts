import { Component } from '@angular/core';
import { RegistrazioneDto } from './chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  sessione: string;
  nickName: string;


  constructor(private http: HttpClient) { }
  registrazione() {
    let ox: Observable<RegistrazioneDto> =
      this.http
        .post<RegistrazioneDto>("http://localhost:8080/registrazione01",
        {nickName: this.nickName});
  }
}
