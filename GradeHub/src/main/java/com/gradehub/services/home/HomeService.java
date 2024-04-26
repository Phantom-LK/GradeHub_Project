package com.gradehub.services.home;

import com.gradehub.dto.TeacherDto;
import com.gradehub.entities.Teacher;
import com.gradehub.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final TeacherRepository teacherRepository;

    public List<TeacherDto> getAllTeachers(){
        return teacherRepository.findAll().stream().map(Teacher::getTeacherDto).collect(Collectors.toList());
    }
}
