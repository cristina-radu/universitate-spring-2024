package org.example.many_to_many_unidirectional_no_cascade.respository;


import org.example.many_to_many_unidirectional_no_cascade.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByIdIn(List<Integer> ids);
}
