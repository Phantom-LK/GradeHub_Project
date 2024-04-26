package com.gradehub.gradeentrymanagement.service;

import com.gradehub.gradeentrymanagement.entity.Grade;
import com.gradehub.gradeentrymanagement.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeEntryService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade grade) {
        Grade existingGrade = gradeRepository.findById(id).orElse(null);
        if (existingGrade != null) {
            existingGrade.setScore(grade.getScore());
            return gradeRepository.save(existingGrade);
        }
        return null;
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
