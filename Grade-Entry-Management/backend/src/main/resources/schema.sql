/* The Database - MySQL */

/* Student Table */

CREATE TABLE student (
  id INT(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  address VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);


/* Course Table */

CREATE TABLE course (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  code VARCHAR(10) NOT NULL,
  instructor_id INT(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (instructor_id) REFERENCES instructor(id)
);


/* Grade Table */

CREATE TABLE grade (
  id INT(11) NOT NULL AUTO_INCREMENT,
  student_id INT(11) NOT NULL,
course_id INT(11) NOT NULL,
  participation DECIMAL(5,2) NOT NULL,
  homework DECIMAL(5,2) NOT NULL,
  tests DECIMAL(5,2) NOT NULL,
  projects DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (student_id) REFERENCES student(id),
  FOREIGN KEY (course_id) REFERENCES course(id)
);


/* Instructor/Teacher Table */

CREATE TABLE instructor (
  id INT(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  address VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

