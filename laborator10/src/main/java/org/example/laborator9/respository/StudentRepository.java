package org.example.laborator9.respository;

import org.example.laborator9.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByAgeBetween(Integer minLimit, Integer maxLimit);
    List<Student> findAllByAddress_City(String cityName);
}
