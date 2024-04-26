package com.gradehub.services.admin;
import com.gradehub.dto.*;
import com.gradehub.entities.StudentLeave;
import com.gradehub.entities.Teacher;
import com.gradehub.entities.User;
import com.gradehub.enums.StudentLeaveStatus;
import com.gradehub.enums.UserRole;
import com.gradehub.repositories.StudentLeaveRepository;
import com.gradehub.repositories.TeacherRepository;
import com.gradehub.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    private final StudentLeaveRepository studentLeaveRepository;
    private final TeacherRepository teacherRepository;

    public AdminServiceImpl(UserRepository userRepository, StudentLeaveRepository studentLeaveRepository, TeacherRepository teacherRepository) {
        this.userRepository = userRepository;
        this.studentLeaveRepository = studentLeaveRepository;
        this.teacherRepository = teacherRepository;
    }

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (adminAccount == null){
            User admin = new User();
            admin.setEmail("admin@test.com");
            admin.setName("admin");
            admin.setRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);

        }

    }

    @Override
    public StudentDto postStudent(StudentDto studentDto) {
        Optional<User> optionalUser = userRepository.findFirstByEmail(studentDto.getEmail());
        if (optionalUser.isEmpty()){
            User user = new User();
            BeanUtils.copyProperties(studentDto,user);
            user.setPassword(new BCryptPasswordEncoder().encode(studentDto.getPassword()));
            user.setRole(UserRole.STUDENT);
            User createdUser = userRepository.save(user);
            StudentDto createdStudentDto = new StudentDto();
            createdStudentDto.setId(createdUser.getId());
            createdStudentDto.setEmail(createdUser.getEmail());
            return createdStudentDto;
        }
        return null;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return userRepository.findAllByRole(UserRole.STUDENT).stream().map(User::getStudentDto).collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Long studentId) {
        userRepository.deleteById(studentId);

    }

    @Override
    public SingleStudentDto getStudentById(Long studentId) {
        Optional<User> optionalUser = userRepository.findById(studentId);
        SingleStudentDto singleStudentDto = new SingleStudentDto();
        optionalUser.ifPresent(user -> singleStudentDto.setStudentDto(optionalUser.get().getStudentDto()));
        return singleStudentDto;
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

    @Override
    public List<StudentLeaveDto> getallApppliedLeaves() {
        return  studentLeaveRepository.findAll().stream().map(StudentLeave::getStudentLeaveDto).collect(Collectors.toList());
    }

    @Override
    public StudentLeaveDto changeLeaveStatus(Long leaveId, String status) {
        Optional<StudentLeave> optionalStudentLeave = studentLeaveRepository.findById(leaveId);
        if (optionalStudentLeave.isPresent()){
            StudentLeave studentLeave = optionalStudentLeave.get();
            if (Objects.equals(status,"Approve")){
                studentLeave.setStudentLeaveStatus(StudentLeaveStatus.Approved);
            }else {
                studentLeave.setStudentLeaveStatus(StudentLeaveStatus.Disapproved);
            }
            StudentLeave updatedStudentLeave = studentLeaveRepository.save(studentLeave);
            StudentLeaveDto updatedStudentLeaveDto = new StudentLeaveDto();
            updatedStudentLeaveDto.setId(updatedStudentLeave.getId());
            return updatedStudentLeaveDto;
        }
        return null;
    }

    @Override
    public TeacherDto postTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        Teacher createdTeacher = teacherRepository.save(teacher);
        TeacherDto createdTeacherDto = new TeacherDto();
        createdTeacherDto.setId(createdTeacher.getId());
        return createdTeacherDto;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream().map(Teacher::getTeacherDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public SingleTeacherDto getTeacherById(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if (optionalTeacher.isPresent()){
            SingleTeacherDto singleTeacherDto = new SingleTeacherDto();
            singleTeacherDto.setTeacherDto(optionalTeacher.get().getTeacherDto());
            return singleTeacherDto;
        }
        return null;
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto teacherDto) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
            if (optionalTeacher.isPresent()){
                Teacher updateTeacher = optionalTeacher.get();
                updateTeacher.setName(teacherDto.getName());
                updateTeacher.setGender(teacherDto.getGender());
                updateTeacher.setAddress(teacherDto.getAddress());
                updateTeacher.setDob(teacherDto.getDob());
                updateTeacher.setDepartment(teacherDto.getDepartment());
                updateTeacher.setQualification(teacherDto.getQualification());
                Teacher updatedTeacher = teacherRepository.save(updateTeacher);
                TeacherDto updatedTeacherDto = new TeacherDto();
                updatedTeacherDto.setId(updatedTeacher.getId());
                return updatedTeacherDto;

        }
        return null;
    }


}
