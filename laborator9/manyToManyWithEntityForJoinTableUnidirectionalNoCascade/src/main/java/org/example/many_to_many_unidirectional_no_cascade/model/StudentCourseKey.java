package org.example.many_to_many_unidirectional_no_cascade.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentCourseKey implements Serializable {
    private Integer studentId;
    private Integer courseId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
