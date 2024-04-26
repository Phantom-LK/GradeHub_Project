/*export interface Course {
    id: number;
    name: string;
    instructor: string;
    students: Student[];
  }*/

  export interface Student {
    // Define the Course interface here
  }
  
  export interface Course {
    readonly id: number;
    readonly name: string;
    readonly email: string;
    readonly courses: readonly Student[];
  }