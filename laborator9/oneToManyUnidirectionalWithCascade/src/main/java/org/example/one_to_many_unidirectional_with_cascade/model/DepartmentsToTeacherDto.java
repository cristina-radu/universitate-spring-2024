package org.example.one_to_many_unidirectional_with_cascade.model;

import java.util.List;

public class DepartmentsToTeacherDto {
    private Integer teacherId;
    private List<Integer> departmentIds;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public List<Integer> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Integer> departmentIds) {
        this.departmentIds = departmentIds;
    }
}
