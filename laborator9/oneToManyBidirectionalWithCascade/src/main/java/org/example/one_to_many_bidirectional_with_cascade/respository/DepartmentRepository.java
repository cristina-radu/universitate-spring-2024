package org.example.one_to_many_bidirectional_with_cascade.respository;


import org.example.one_to_many_bidirectional_with_cascade.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findAllByIdIn(List<Integer> ids);
}
