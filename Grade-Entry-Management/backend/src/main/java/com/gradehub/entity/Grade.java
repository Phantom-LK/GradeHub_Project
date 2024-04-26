package com.gradehub.gradeentrymanagement.entity;

import com.gradehub.gradeentrymanagement.entity.Course;
import com.gradehub.gradeentrymanagement.entity.Student;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grade")
public class Grade implements Serializable {

    @EmbeddedId
    private GradeId id = new GradeId();

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @Column(nullable = false)
    private Double score;

    public Grade() {}

    public Grade(Course course, Student student, Double score) {
        this.course = course;
        this.student = student;
        this.score = score;
    }

    public GradeId getId() {
        return id;
    }

    public void setId(GradeId id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}