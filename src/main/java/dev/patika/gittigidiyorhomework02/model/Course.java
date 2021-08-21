package dev.patika.gittigidiyorhomework02.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Course {

    //instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "credit_score")
    private String creditScore;


    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id",nullable = false)
    private Instructor instructor;

    //Constructors


    public Course(String courseName, String courseCode, String creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }

    public Course() {
    }

    //getters & setters


    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    //equals & hahsCode & toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore='" + creditScore + '\'' +
                '}';
    }
}