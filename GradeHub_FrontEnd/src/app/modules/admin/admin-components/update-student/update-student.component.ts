import { Component } from '@angular/core';
import { AdminService } from '../../admin-service/admin.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.scss'
})
export class UpdateStudentComponent {

  studentId: number = this.activatedRoute.snapshot.params['studentId'];
  validateForm: FormGroup;
  isSpinning: boolean;
  Faculty:  string[] = ["Computer","Science","Engineering","Arts and Humanities", "Business",];
  Gender: string[ ] = [ "Male", "Female","Other" ];


  constructor (private service: AdminService,
    private activatedRoute: ActivatedRoute,
  private fb: FormBuilder){

    }
    ngOnInit(){
      this.validateForm = this.fb.group({
        email:['',Validators.required],
        name:['',Validators.required],
        fathername:['',Validators.required],
        mothername:['',Validators.required],
        faculty:['',Validators.required],
        dob:['',Validators.required],
        addres:['',Validators.required],
        gender:['',Validators.required]
      })
      this.getStudentById();
    }

    getStudentById(){
      this.service.getStudentById(this.studentId).subscribe((res)=>{
        console.log(res);      })
    }
  

}
