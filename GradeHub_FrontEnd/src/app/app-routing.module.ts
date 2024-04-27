import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { noAuthGuard } from './guards/noAuth-guard/no-auth.guard';
import { DashboardComponent } from './modules/admin/admin-components/dashboard/dashboard.component';

const routes: Routes = [
  {path:"login", component:LoginComponent, canActivate:[noAuthGuard]}, 
  {path:"admin", loadChildren:()=>import("./modules/admin/admin.module").then(m => m.AdminModule)},
  {path:"student",loadChildren:() =>import("./modules/student/student.module").then(m => m.StudentModule)},
  {path:'',component:DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
