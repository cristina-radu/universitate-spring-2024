package org.example.many_to_many_unidirectional_no_cascade.dto;

public class StudentCourseDto {
    private StudentDto student;
    private CourseDto course;
    private Float score;

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
