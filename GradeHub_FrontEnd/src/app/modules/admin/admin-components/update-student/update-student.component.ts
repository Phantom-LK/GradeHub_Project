import { Component } from '@angular/core';
import { AdminService } from '../../admin-service/admin.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.scss'
})
export class UpdateStudentComponent {

  studentId: number = this.activatedRoute.snapshot.params['studentId'];

  constructor (private service: AdminService,
    private activatedRoute: ActivatedRoute){

    }
    ngOnInit(){
      this.getStudentById();
    }

    getStudentById(){
      this.service.getStudentById(this.studentId).subscribe((res)=>{
        console.log(res);      })
    }
  

}
