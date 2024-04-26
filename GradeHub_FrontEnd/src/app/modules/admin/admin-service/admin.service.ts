import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASIC_URL = ["http://localhost:8080/"];

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  addStudent(studentDto:any){
    return this.http.post<[]>(BASIC_URL + "api/admin/students", studentDto);
  }
}
