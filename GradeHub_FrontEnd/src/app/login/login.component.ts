import { Component } from '@angular/core';
import { ServicesService } from '../services/services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { response } from 'express';
import { StorageService } from '../services/storage/storage.service';
import { Router } from '@angular/router';
import { error } from 'console';
import { MatAnchor } from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  loginForm:FormGroup;

  constructor(
    private service: ServicesService,
    private fb: FormBuilder,
    private router: Router,
    private snackbar:MatSnackBar

  ){}

  ngOnInit(){
    this.loginForm = this.fb.group({
      email: ['',Validators.required],
      password:  ['',Validators.required],
  })
}
 login(){
  console.log(this.loginForm.value);
  this.service.login(
    this.loginForm.get(['email']).value,
    this.loginForm.get(['password']).value,
  ).subscribe((response)=>{
    console.log(response);
    if(StorageService.isAdminLoggedIn()){
      this.router.navigateByUrl("admin/dashboard");
    }else if(StorageService.isStudentLoggedIn()){
      this.router.navigateByUrl( "student/dashbord");

    }
  }),
  error =>{
    if(error.status == 406){
      this.snackbar.open("user is not active","Close",{
        duration:5000
      });
    } else{
      this.snackbar.open("Invalid Credentials","Close",{
        duration:5000
      });
    }
  }
 } 

}
