package org.example.one_to_many_bidirectional_with_cascade.respository;

import org.example.one_to_many_bidirectional_with_cascade.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
