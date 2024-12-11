package org.example.one_to_many_unidirectional_no_cascade.mapper;

import org.example.one_to_many_unidirectional_no_cascade.dto.TeacherDto;
import org.example.one_to_many_unidirectional_no_cascade.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public List<Teacher> fromDtosToEnities(List<TeacherDto> teacherDtos){
        return teacherDtos.stream()
                .map(elem -> fromDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public Teacher fromDtoToEntity(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        return teacher;
    }

    public List<TeacherDto> fromEntitiesToDtos(List<Teacher> teachers){
        return teachers.stream()
                .map(elem -> fromEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public TeacherDto fromEntityToDto(Teacher teacher){
        TeacherDto teacherdto = new TeacherDto();
        teacherdto.setId(teacher.getId());
        teacherdto.setFirstName(teacher.getFirstName());
        teacherdto.setLastName(teacher.getLastName());
        return teacherdto;
    }
}
