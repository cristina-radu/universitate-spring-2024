package org.example.many_to_many_unidirectional_no_cascade.mapper;

import org.example.many_to_many_unidirectional_no_cascade.dto.StudentDto;
import org.example.many_to_many_unidirectional_no_cascade.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public List<Student> fromDtosToEnities(List<StudentDto> studentDtos){
        return studentDtos.stream()
                .map(elem -> fromDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public Student fromDtoToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        return student;
    }

    public List<StudentDto> fromEntitiesToDtos(List<Student> students){
        return students.stream()
                .map(elem -> fromEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public StudentDto fromEntityToDto(Student student){
        StudentDto teacherdto = new StudentDto();
        teacherdto.setId(student.getId());
        teacherdto.setFirstName(student.getFirstName());
        teacherdto.setLastName(student.getLastName());
        return teacherdto;
    }
}
