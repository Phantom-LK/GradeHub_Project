import { Component } from '@angular/core';
import { AdminService } from '../../admin-service/admin.service';
import { StudentRoutingModule } from '../../../student/student-routing.module';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-all-students',
  templateUrl: './all-students.component.html',
  styleUrl: './all-students.component.scss'
})
export class AllStudentsComponent {

  students: any;

  constructor(private service: AdminService,private snackBar:MatSnackBar){

  }

  ngOnInit(){
    this.getAllStudents();
  }

  getAllStudents(){
    this.service.getAllStudents().subscribe((res)=>{
      console.log(res)
      this.students=res;
    })
  }
  deleteAllstudent(studentId:number){
    this.service.deleteStudents(studentId).subscribe((res)=>{
      console.log(res);
      this.getAllStudents();
      this.snackBar.open("Student Deleted Successfully!","Close",{duration:5000} );
    })
  }

}
