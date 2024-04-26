package com.gradehub.services.student;

import com.gradehub.dto.SingleStudentDto;
import com.gradehub.dto.StudentDto;
import com.gradehub.dto.StudentLeaveDto;
import com.gradehub.entities.StudentLeave;
import com.gradehub.entities.User;
import com.gradehub.enums.StudentLeaveStatus;
import com.gradehub.repositories.StudentLeaveRepository;
import com.gradehub.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentserviceImpl implements StudentService {

    private final UserRepository userRepository;

    private  final StudentLeaveRepository studentLeaveRepository;

    @Override
    public SingleStudentDto getStudentById(Long studentId) {
        Optional<User> optionalUser = userRepository.findById(studentId);
        SingleStudentDto singleStudentDto = new SingleStudentDto();
        optionalUser.ifPresent(user -> singleStudentDto.setStudentDto(optionalUser.get().getStudentDto()));
        return singleStudentDto;
    }

    @Override
    public StudentLeaveDto applyLeave(StudentLeaveDto studentLeaveDto) {
        Optional<User> optionalUser = userRepository.findById(studentLeaveDto.getUserid());
        if (optionalUser.isPresent()){
            StudentLeave studentLeave = new StudentLeave();
            studentLeave.setSubject(studentLeaveDto.getSubject());
            studentLeave.setBody(studentLeaveDto.getBody());
            studentLeave.setDate(new Date());
            studentLeave.setStudentLeaveStatus(StudentLeaveStatus.Pending);
            studentLeave.setUser(optionalUser.get());
           StudentLeave SubmittedStudentLeave = studentLeaveRepository.save(studentLeave);
           StudentLeaveDto studentLeaveDto1 = new StudentLeaveDto();
           studentLeaveDto1.setId(SubmittedStudentLeave.getId());
           return studentLeaveDto1;

        }
        return null;

    }

    @Override
    public List<StudentLeaveDto> getallApppliedLeavesByStudentId(Long studentId) {
        User user = userRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("User not found with id " + studentId));
        return studentLeaveRepository.findAllByUser(user).stream().map(StudentLeave::getStudentLeaveDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Optional<User> optionalUser= userRepository.findById(studentId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(studentDto.getName());
            user.setGender(studentDto.getGender());
            user.setAddress(studentDto.getAddress());
            user.setDob(studentDto.getDob());
            user.setFaculty(studentDto.getFaculty());
            user.setFatherName(studentDto.getFatherName());
            user.setMotherName(studentDto.getMotherName());
            user.setEmail(studentDto.getEmail());
            User updatedStudent = userRepository.save(user);
            StudentDto updatedStudentDto = new StudentDto();
            updatedStudentDto.setId(updatedStudent.getId());
            return updatedStudentDto;
        }
        return null;
    }
    }

