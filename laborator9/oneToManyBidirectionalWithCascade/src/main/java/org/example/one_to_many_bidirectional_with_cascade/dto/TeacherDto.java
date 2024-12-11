package org.example.one_to_many_bidirectional_with_cascade.dto;

import java.util.List;

public class TeacherDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<DisciplineDto> disciplines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<DisciplineDto> getDepartments() {
        return disciplines;
    }

    public void setDepartments(List<DisciplineDto> disciplines) {
        this.disciplines = disciplines;
    }
}
