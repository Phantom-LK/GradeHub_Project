import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostStudentComponent } from './post-student.component';

describe('PostStudentComponent', () => {
  let component: PostStudentComponent;
  let fixture: ComponentFixture<PostStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PostStudentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PostStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
