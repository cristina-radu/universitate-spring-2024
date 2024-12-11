package org.example.many_to_many_unidirectional_no_cascade.dto;

public class CourseDto {
    private Integer id;
    private String name;
    private StudentDto student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
