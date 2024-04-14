import { Component } from '@angular/core';
import { ServicesService } from '../services/services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { response } from 'express';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  loginForm:FormGroup;

  constructor(
    private service: ServicesService,
    private fb: FormBuilder
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
  })
 }

}
