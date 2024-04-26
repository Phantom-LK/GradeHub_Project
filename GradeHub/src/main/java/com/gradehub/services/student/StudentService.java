package com.gradehub.services.student;

import com.gradehub.dto.SingleStudentDto;
import com.gradehub.dto.StudentDto;
import com.gradehub.dto.StudentLeaveDto;

import java.util.List;

public interface StudentService {
    SingleStudentDto getStudentById(Long studentId);

    StudentLeaveDto applyLeave(StudentLeaveDto studentLeaveDto);

    List<StudentLeaveDto> getallApppliedLeavesByStudentId(Long studentId);

    StudentDto updateStudent(Long studentId, StudentDto studentDto);
}
