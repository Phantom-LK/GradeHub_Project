import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../../admin-service/admin.service';
import { error } from 'console';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-post-student',
  templateUrl: './post-student.component.html',
  styleUrl: './post-student.component.scss'
})
export class PostStudentComponent {

  Faculty:  string[] = ["Computer","Science","Engineering","Arts and Humanities", "Business",];
  Gender: string[ ] = [ "Male", "Female","Other" ];
  isSpining: boolean
  validateForm: FormGroup

  confirmationValidator = (contol: FormGroup):{[s:string]: boolean} =>{
    if(!contol.value){
      return {required:true};
 
    }else if(contol.value  !== this.validateForm.controls['password'].value) {
      return{confirm:true, error:true};
   }
   return{};
   }

   constructor(
    private service: AdminService,
    private fb: FormBuilder,
    private snackbar: MatSnackBar
   ){}

   ngOnInit(){
    this.validateForm = this.fb.group({
      email:['',Validators.required],
      name:['',Validators.required],
      password:['',Validators.required],
      checkPassword:['',Validators.required , this.confirmationValidator],
      fathername:['',Validators.required],
      mothername:['',Validators.required],
      faculty:['',Validators.required],
      dob:['',Validators.required],
      addres:['',Validators.required],
      gender:['',Validators.required]
    })
   }
   postStudent(){
    console.log(this.validateForm.value);
    this.isSpining = true;
    this.service.addStudent(this.validateForm.value).subscribe((res) =>{
      this.isSpining = false;
      if(res.id != null){
        this.snackbar.open("Successfully added student!", 'Close', { duration: 5000 });
      }else{
        this.snackbar.open("Successfully already exist!", 'Close', { duration: 5000 });
      }
    })
   }

}
