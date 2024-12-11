package org.example.many_to_many_unidirectional_no_cascade.model;

import java.util.List;

public class CoursesToStudentDto {
    private Integer studentId;
    private List<Integer> courseIds;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }
}
