package org.example.many_to_many_unidirectional_no_cascade.respository;

import org.example.many_to_many_unidirectional_no_cascade.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
