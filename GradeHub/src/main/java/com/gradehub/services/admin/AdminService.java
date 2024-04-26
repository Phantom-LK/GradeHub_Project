package com.gradehub.services.admin;

import com.gradehub.dto.*;

import java.util.List;

public interface AdminService {
    StudentDto postStudent(StudentDto studentDto);

    List<StudentDto> getAllStudent();

    void deleteStudent(Long studentId);

    SingleStudentDto getStudentById(Long studentId);

    StudentDto updateStudent(Long studentId, StudentDto studentDto);

    List<StudentLeaveDto> getallApppliedLeaves();

    StudentLeaveDto changeLeaveStatus(Long leaveId, String status);

    TeacherDto postTeacher(TeacherDto teacherDto);

    List<TeacherDto> getAllTeachers();

    void deleteTeacher(Long teacherId);

    SingleTeacherDto getTeacherById(Long teacherId);
}
