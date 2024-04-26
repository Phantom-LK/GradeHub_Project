/*export interface Student {
    id: number;
    name: string;
    email: string;
    courses: Course[];
  }*/

  export interface Course {
    // Define the Course interface here
  }
  
  export interface Student {
    readonly id: number;
    readonly name: string;
    readonly email: string;
    readonly courses: readonly Course[];
  }