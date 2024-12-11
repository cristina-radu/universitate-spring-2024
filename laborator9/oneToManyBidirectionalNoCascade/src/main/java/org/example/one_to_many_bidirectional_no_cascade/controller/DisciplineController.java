package org.example.one_to_many_bidirectional_no_cascade.controller;

import org.example.one_to_many_bidirectional_no_cascade.dto.DisciplineDto;
import org.example.one_to_many_bidirectional_no_cascade.service.DepartmentService;
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
    public DisciplineDto saveDepartment(@RequestBody DisciplineDto discipline){
        return departmentService.saveDepartment(discipline);
    }

    @GetMapping
    public List<DisciplineDto> getDepartment(){
        return departmentService.getDisciplines();
    }

}
