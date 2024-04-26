import { Component, OnInit } from '@angular/core';
import { GradeService } from '../services/grade.service';
import { Course } from '../models/course.model';
import { Student } from '../models/student.model';
import { Grade } from '../models/grade.model';

@Component({
  selector: 'app-grade-entry',
  templateUrl: './grade-entry.component.html',
  styleUrls: './grade-entry.component.css'
})
export class GradeEntryComponent implements OnInit {
  courses: Course[];
  students: Student[];
  grades: Grade[];
  selectedCourse: Course;
  selectedStudent: Student;
  grade: Grade;

  constructor(private gradeService: GradeService) {}

  ngOnInit(): void {
    this.courses = this.gradeService.getCourses();
    this.students = this.gradeService.getStudents();
    this.grades = this.gradeService.getGrades();
  }

  onSelectCourse(course: Course): void {
    this.selectedCourse = course;
    this.selectedStudent = null;
    this.grade = null;
  }

  onSelectStudent(student: Student): void {
    this.selectedStudent = student;
    this.grade = this.grades.find(grade => grade.student.id === student.id && grade.course.id === this.selectedCourse.id);
  }

  onSubmitGrade(): void {
    if (this.grade) {
      this.gradeService.updateGrade(this.grade);
    } else {
      this.grade = new Grade(null, this.selectedCourse, this.selectedStudent, 0);
      this.gradeService.addGrade(this.grade);
    }
    this.grade = null;
  }
}