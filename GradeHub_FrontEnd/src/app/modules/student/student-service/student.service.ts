import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = ["http://localhost:8080/"];

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http:HttpClient) { }

  getStudentById(studennt:number):Observable<any> {
    return this.http.get<[]>(BASIC_URL + 'api/admin/student/${studentID}',{
        headers:this.createAuthorizationHeader( )
    }
  )
  }
}
