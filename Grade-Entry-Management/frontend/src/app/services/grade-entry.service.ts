import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GradeEntryService {

  private baseUrl = 'http://localhost:8080/api/grades';

  constructor(private http: HttpClient) { }

  createGrade(grade: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, grade);
  }

  getGradeList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getGrade(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  deleteGrade(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getCourse(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/course/${id}`);
  }

  getStudent(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/student/${id}`);
  }
}