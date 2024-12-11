package org.example.one_to_many_unidirectional_with_cascade.mapper;

import org.example.one_to_many_unidirectional_with_cascade.dto.DisciplineDto;
import org.example.one_to_many_unidirectional_with_cascade.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {

    public List<Department> fromDtosToEnities(List<DisciplineDto> disciplineDtos){
        return disciplineDtos.stream()
                .map(elem -> fromDtoToEntity(elem))
                .collect(Collectors.toList());
    }

    public Department fromDtoToEntity(DisciplineDto disciplineDto){
        Department discipline = new Department();
        discipline.setId(disciplineDto.getId());
        discipline.setName(disciplineDto.getName());
        return discipline;
    }

    public List<DisciplineDto> fromEntitiesToDtos(List<Department> disciplines){
        return disciplines.stream()
                .map(elem -> fromEntityToDto(elem))
                .collect(Collectors.toList());
    }

    public DisciplineDto fromEntityToDto(Department discipline){
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(discipline.getId());
        disciplineDto.setName(discipline.getName());
        return disciplineDto;
    }
}
