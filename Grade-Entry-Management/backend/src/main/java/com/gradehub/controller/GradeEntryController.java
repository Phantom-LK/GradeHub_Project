package com.gradehub.gradeentrymanagement.controller;

import com.gradehub.gradeentrymanagement.entity.Grade;
import com.gradehub.gradeentrymanagement.service.GradeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade-entry")
public class GradeEntryController {

    @Autowired
    private GradeEntryService gradeEntryService;

    @GetMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<List<Grade>> getAllGrades() {
        return new ResponseEntity<>(gradeEntryService.getAllGrades(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        return new ResponseEntity<>(gradeEntryService.getGradeById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        return new ResponseEntity<>(gradeEntryService.createGrade(grade), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        return new ResponseEntity<>(gradeEntryService.updateGrade(id, grade), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeEntryService.deleteGrade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}