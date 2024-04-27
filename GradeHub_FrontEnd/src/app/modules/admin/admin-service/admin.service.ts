import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StorageService } from '../../../services/storage/storage.service';
import { Observable } from 'rxjs';

const BASIC_URL = ["http://localhost:8080/"];

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  addStudent(studentDto:any):Observable<any>{
    return this.http.post<[]>(BASIC_URL + "api/admin/students", studentDto,{
      headers:this.createAuthorizationHeader(),

    });
  }
  getAllStudents():Observable<any> {
    return this.http.get<[]>(BASIC_URL + "api/admin/allStudents",{
        headers:this.createAuthorizationHeader( )
    }
  )
  }

  deleteStudents(studentId:any):Observable<any> {
    return this.http.delete<[]>(BASIC_URL + 'api/admin/student/${studentId}',{
        headers:this.createAuthorizationHeader( )
    }
  )
  }

  getStudentById(studennt:number):Observable<any> {
    return this.http.get<[]>(BASIC_URL + 'api/admin/student/${studentID}',{
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
