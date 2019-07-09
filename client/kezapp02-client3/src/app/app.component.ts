import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';

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
    let ox: Observable

  }
}
