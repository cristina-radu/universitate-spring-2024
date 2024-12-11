package org.example.one_to_many_bidirectional_no_cascade.service;

import org.example.one_to_many_bidirectional_no_cascade.dto.DisciplineDto;
import org.example.one_to_many_bidirectional_no_cascade.mapper.DepartmentMapper;
import org.example.one_to_many_bidirectional_no_cascade.model.Department;
import org.example.one_to_many_bidirectional_no_cascade.model.Teacher;
import org.example.one_to_many_bidirectional_no_cascade.respository.DepartmentRepository;
import org.example.one_to_many_bidirectional_no_cascade.respository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final TeacherRepository teacherRepository;
    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper, TeacherRepository teacherRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.teacherRepository = teacherRepository;
    }

    public DisciplineDto saveDepartment(DisciplineDto discipline){
        return departmentMapper.fromEntityToDto(
                departmentRepository.save(departmentMapper.fromDtoToEntity(discipline)));
    }

    public List<DisciplineDto> getDisciplines(){
        return departmentMapper.fromEntitiesToDtos(departmentRepository.findAll());
    }


    public void addTeacherToDiscipline(Integer disciplineId, Integer teacherId){
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
        Optional<Department> disciplineOptional = departmentRepository.findById(disciplineId);
        if (!teacherOptional.isPresent() || !disciplineOptional.isPresent()) {
            throw new RuntimeException("Discipline or/and teacher are not present in the db.");
        }
        Department discipline = disciplineOptional.get();
        Teacher teacher = teacherOptional.get();
        discipline.setTeacher(teacher);
        departmentRepository.save(discipline);
    }
}
