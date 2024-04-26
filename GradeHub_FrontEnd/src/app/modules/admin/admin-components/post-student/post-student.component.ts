import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';

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

}
