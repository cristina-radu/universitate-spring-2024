package org.example.one_to_many_bidirectional_no_cascade.service;

import org.example.one_to_many_bidirectional_no_cascade.dto.TeacherDto;
import org.example.one_to_many_bidirectional_no_cascade.mapper.TeacherDepartmentMapper;
import org.example.one_to_many_bidirectional_no_cascade.model.Department;
import org.example.one_to_many_bidirectional_no_cascade.model.DepartmentsToTeacherDto;
import org.example.one_to_many_bidirectional_no_cascade.model.Teacher;
import org.example.one_to_many_bidirectional_no_cascade.respository.DepartmentRepository;
import org.example.one_to_many_bidirectional_no_cascade.respository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    private DepartmentRepository departmentRepository;
    private TeacherDepartmentMapper teacherDepartmentMapper;

    public TeacherService(TeacherRepository teacherRepository, DepartmentRepository departmentRepository, TeacherDepartmentMapper teacherDepartmentMapper) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
        this.teacherDepartmentMapper = teacherDepartmentMapper;
    }

    public List<TeacherDto> getTeachers() {
        return teacherDepartmentMapper.fromTeacherEntitiesToDtos(teacherRepository.findAll());
    }

    public TeacherDto saveTeacher(TeacherDto teacher) {
        Teacher newTeacher = teacherDepartmentMapper.fromTeacherDtoToEntity(teacher);
        Teacher savedTeacher = teacherRepository.save(newTeacher);
        List<Department> newDepartments = newTeacher.getDepartments();
        // for bidirectional, we have to set the parent on the children
        newDepartments.forEach(elem -> elem.setTeacher(savedTeacher));

        List<Department> savedDepartments = departmentRepository.saveAll(newDepartments);
        newTeacher.setDepartments(savedDepartments);

        return teacherDepartmentMapper.fromTeacherEntityToDto(savedTeacher);
    }

    public TeacherDto updateTeacher(TeacherDto teacher) {
        return teacherDepartmentMapper.fromTeacherEntityToDto(teacherRepository.save(teacherDepartmentMapper.fromTeacherDtoToEntity(teacher)));
    }

    public void addDepartmentsToTeacher(DepartmentsToTeacherDto departmentsToTeacherDto) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(departmentsToTeacherDto.getTeacherId());
        List<Department> departments = departmentRepository.findAllByIdIn(departmentsToTeacherDto.getDepartmentIds());
        if (!teacherOptional.isPresent() || departments.size() == 0) {
            throw new RuntimeException(" teacher or departmentIds are not present in the db.");
        }
        departments.forEach(elem -> elem.setTeacher(teacherOptional.get()));
        departmentRepository.saveAll(departments);
    }

}
