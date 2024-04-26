package com.gradehub.gradeentrymanagement.utils;

import com.gradehub.gradeentrymanagement.entity.Grade;

import java.util.List;

public class GradeCalculator {

    public Double calculateGPA(List<Grade> grades) {
        Double totalGPA = 0.0;
        Double totalCredits = 0.0;

        for (Grade grade : grades) {
            Double gradePoints = 0.0;

            if (grade.getScore() >= 90) {
                gradePoints = 4.0;
            } else if (grade.getScore() >= 80) {
                gradePoints = 3.0;
            } else if (grade.getScore() >= 70) {
                gradePoints = 2.0;
            } else if (grade.getScore() >= 60) {
                gradePoints = 1.0;
            }

            Double credits = grade.getCourse().getCredits();
            totalGPA += gradePoints * credits;
            totalCredits += credits;
        }

        return totalGPA / totalCredits;
    }
}