import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const BASIC_URL = ['https://localhost:8080/'];

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private http: HttpClient) { }

  login(loginRequest: any): Observable<any> {
    return this.http.post(BASIC_URL + 'authenticate', loginRequest);
  }
}
