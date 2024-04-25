package com.gradehub.services.student;

import com.gradehub.dto.SingleStudentDto;
import com.gradehub.dto.StudentLeaveDto;
import com.gradehub.entities.User;
import com.gradehub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentserviceImpl implements StudentService {

    private final UserRepository userRepository;

    @Override
    public SingleStudentDto getStudentById(Long studentId) {
        Optional<User> optionalUser = userRepository.findById(studentId);
        SingleStudentDto singleStudentDto = new SingleStudentDto();
        optionalUser.ifPresent(user -> singleStudentDto.setStudentDto(optionalUser.get().getStudentDto()));
        return singleStudentDto;
    }

    @Override
    public StudentLeaveDto applyLeave(StudentLeaveDto studentLeaveDto) {
        return null;
    }
}
