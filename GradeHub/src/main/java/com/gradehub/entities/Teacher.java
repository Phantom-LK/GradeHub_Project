package com.gradehub.entities;

import com.gradehub.dto.TeacherDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "teachers")
public class Teacher  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String department;
    private String qualification;
    private Date dob;
    private String address;

    public TeacherDto getTeacherDto(){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(id);
        teacherDto.setName(name);
        teacherDto.setGender(gender);
        teacherDto.setAddress(address);
        teacherDto.setDepartment(department);
        teacherDto.setQualification(qualification);
        teacherDto.setDob(dob);
        return teacherDto;
    }

}
