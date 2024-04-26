package com.gradehub.services.student;

import com.gradehub.dto.SingleStudentDto;
import com.gradehub.dto.StudentLeaveDto;

public interface StudentService {
    SingleStudentDto getStudentById(Long studentId);

    StudentLeaveDto applyLeave(StudentLeaveDto studentLeaveDto);

    SingleStudentDto getallApppliedLeavesByStudentId(Long studentId);
}
