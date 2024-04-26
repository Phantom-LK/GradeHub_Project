import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './admin-components/dashboard/dashboard.component';
import { AdminGuard } from '../../guards/admin-guard/admin.guard';
import { PostStudentComponent } from './admin-components/post-student/post-student.component';

const routes: Routes = [
  {path:"dashboard",component:DashboardComponent,canActivate:[AdminGuard]},
  {path:"student",component:PostStudentComponent,canActivate:[AdminGuard]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }

