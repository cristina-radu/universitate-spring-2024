package org.example.one_to_many_bidirectional_no_cascade.mapper;

import org.example.one_to_many_bidirectional_no_cascade.dto.DisciplineDto;
import org.example.one_to_many_bidirectional_no_cascade.dto.TeacherDto;
import org.example.one_to_many_bidirectional_no_cascade.model.Department;
import org.example.one_to_many_bidirectional_no_cascade.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherDepartmentMapper {
    private DepartmentMapper departmentMapper;
    private TeacherMapper teacherMapper;

    public TeacherDepartmentMapper(DepartmentMapper departmentMapper, TeacherMapper teacherMapper) {
        this.departmentMapper = departmentMapper;
        this.teacherMapper = teacherMapper;
    }

    public List<Teacher> fromTeacherDtosToEnities(List<TeacherDto> teacherDtos){
        return teacherDtos.stream()
                .map(elem -> fromTeacherDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public Teacher fromTeacherDtoToEntity(TeacherDto teacherDto){
        Teacher teacher = teacherMapper.fromDtoToEntity(teacherDto);
        if(teacherDto.getDepartments() != null) {
            teacher.setDepartments(departmentMapper.fromDtosToEnities(teacherDto.getDepartments()));
        }
        return teacher;
    }

    public List<TeacherDto> fromTeacherEntitiesToDtos(List<Teacher> teachers){
        return teachers.stream()
                .map(elem -> fromTeacherEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public TeacherDto fromTeacherEntityToDto(Teacher teacher){
        TeacherDto teacherdto = teacherMapper.fromEntityToDto(teacher);
        if(teacher.getDepartments() != null) {
            teacherdto.setDepartments(departmentMapper.fromEntitiesToDtos(teacher.getDepartments()));
        }
        return teacherdto;
    }

    public List<DisciplineDto> fromDepartmentEntitiesToDtos(List<Department> disciplines){
        return disciplines.stream()
                .map(elem -> fromDepartmentEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public DisciplineDto fromDepartmentEntityToDto(Department discipline){
        DisciplineDto disciplineDto = departmentMapper.fromEntityToDto(discipline);
        if(discipline.getTeacher() != null){
            disciplineDto.setTeacher(teacherMapper.fromEntityToDto(discipline.getTeacher()));
        }
        return disciplineDto;
    }

    public List<Department> fromDepartmentDtosToEntities(List<DisciplineDto> disciplineDtos){
        return disciplineDtos.stream()
                .map(elem -> fromDisciplineDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public Department fromDisciplineDtoToEntity(DisciplineDto disciplineDto){
        Department discipline = departmentMapper.fromDtoToEntity(disciplineDto);
        if(disciplineDto.getTeacher() != null){
            discipline.setTeacher(teacherMapper.fromDtoToEntity(disciplineDto.getTeacher()));
        }
        return discipline;
    }
}