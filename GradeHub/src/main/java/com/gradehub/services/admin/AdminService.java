package com.gradehub.services.admin;

import com.gradehub.dto.SingleStudentDto;
import com.gradehub.dto.StudentDto;
import com.gradehub.dto.StudentLeaveDto;

import java.util.List;

public interface AdminService {
    StudentDto postStudent(StudentDto studentDto);

    List<StudentDto> getAllStudent();

    void deleteStudent(Long studentId);

    SingleStudentDto getStudentById(Long studentId);

    StudentDto updateStudent(Long studentId, StudentDto studentDto);

    List<StudentLeaveDto> getallApppliedLeaves();

    StudentLeaveDto changeLeaveStatus(Long leaveId, String status);
}
