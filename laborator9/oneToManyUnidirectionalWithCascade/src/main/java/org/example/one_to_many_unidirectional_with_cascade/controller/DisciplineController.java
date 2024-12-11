package org.example.one_to_many_unidirectional_with_cascade.controller;

import org.example.one_to_many_unidirectional_with_cascade.dto.DisciplineDto;
import org.example.one_to_many_unidirectional_with_cascade.model.DepartmentsToTeacherDto;
import org.example.one_to_many_unidirectional_with_cascade.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DisciplineController {
    private DepartmentService departmentService;

    public DisciplineController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DisciplineDto saveDiscipline(@RequestBody DisciplineDto discipline){
        return departmentService.saveDepartment(discipline);
    }

    @GetMapping
    public List<DisciplineDto> getDisciplines(){
        return departmentService.getDisciplines();
    }

}
