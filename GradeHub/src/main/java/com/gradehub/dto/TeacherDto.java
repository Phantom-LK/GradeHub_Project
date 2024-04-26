package com.gradehub.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherDto {
    private Long id;
    private String name;
    private String gender;
    private String department;
    private String qualification;
    private Date dob;
    private String address;
}
