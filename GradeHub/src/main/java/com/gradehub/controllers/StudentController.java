package com.gradehub.controllers;

import com.gradehub.dto.SingleStudentDto;
import com.gradehub.dto.StudentDto;
import com.gradehub.dto.StudentLeaveDto;
import com.gradehub.services.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private  final StudentService studentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<SingleStudentDto> getStudentById (@PathVariable Long studentId){
        SingleStudentDto singleStudentDto = studentService.getStudentById(studentId);
        if (singleStudentDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(singleStudentDto);
    }

    @PostMapping("/leave")
    public ResponseEntity<?> applyLeave(@RequestBody StudentLeaveDto studentLeaveDto){
        StudentLeaveDto submittedStudentLeaveDto = studentService.applyLeave(studentLeaveDto);
        if (submittedStudentLeaveDto == null)
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.CREATED).body(submittedStudentLeaveDto);
    }

    @GetMapping("/leave/{userId}")
    public ResponseEntity<List<StudentLeaveDto>> getallApppliedLeavesByStudentId (@PathVariable Long userId){
        List<StudentLeaveDto> studentLeaveDtos = (List<StudentLeaveDto>) studentService.getallApppliedLeavesByStudentId(userId);
        if (studentLeaveDtos == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentLeaveDtos);
    }

    @PutMapping ("/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Long studentId,  @RequestBody StudentDto studentDto){
        StudentDto createdStudentDto =  studentService.updateStudent(studentId,studentDto);
        if (createdStudentDto == null)
            return new ResponseEntity<>("Somthing went wrong.", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentDto);
    }



}
