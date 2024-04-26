import { Component } from '@angular/core';
import { StorageService } from './services/storage/storage.service';
import { NavigationEnd, Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'GradeHub_FrontEnd';

  isAdminLoggedIn: boolean;
  isStudentLoggedIn: boolean;

  constructor(
    private router:Router
  ) {
   }

   ngOnInit(){
    this.updateUserLoggedStatus();
    this.router.events.subscribe(event =>{
      if (event  instanceof NavigationEnd) {
        this.updateUserLoggedStatus();
      }
    })
   }

   private updateUserLoggedStatus():  void{
    this.isAdminLoggedIn=StorageService.isAdminLoggedIn();
    this.isStudentLoggedIn=StorageService.isStudentLoggedIn();
   }
   logout(){
    StorageService.logout();
    this.router.navigateByUrl( '/login')
  
   }
}
