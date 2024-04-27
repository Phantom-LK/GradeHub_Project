import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from '../../../services/storage/storage.service';

const BASIC_URL = ["http://localhost:8080/"];

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http:HttpClient) { }

  getStudentById(studennt:number):Observable<any> {
    return this.http.get<[]>(BASIC_URL + 'api/student/${studentID}',{
        headers:this.createAuthorizationHeader( )
    }
  )
  }
  createAuthorizationHeader(): HttpHeaders {
    let authHeaders: HttpHeaders = new HttpHeaders();
    return authHeaders.set(
      'Authorization',"Bearer" + StorageService.getToken()
    );
  }
}
