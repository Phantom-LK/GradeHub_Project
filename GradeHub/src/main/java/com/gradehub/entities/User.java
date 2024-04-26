package com.gradehub.entities;

import com.gradehub.dto.StudentDto;
import com.gradehub.enums.UserRole;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    private String fatherName;
    private String motherName;
    private String faculty;
    private Date dob;
    private String address;
    private String gender;

    private UserRole role;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUsername() {
        return null;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public StudentDto getStudentDto(){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(id);
        studentDto.setName(name);
        studentDto.setEmail(email);
        studentDto.setAddress(address);
        studentDto.setDob(dob);
        studentDto.setFaculty(faculty);
        studentDto.setGender(gender);
        studentDto.setFatherName(fatherName);
        studentDto.setMotherName(motherName);
        return studentDto;
    }



}
