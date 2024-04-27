
import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../student-service/student.service';

interface StudentDto {
  student?: any;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  student: StudentDto = {};

  constructor(private service: StudentService) {}

  ngOnInit(): void {
    this.getStudentById();
  }

  getStudentById(): void {
    this.service.getStudentById(1).subscribe((response) => {
      this.student = response;
    });
  }
}