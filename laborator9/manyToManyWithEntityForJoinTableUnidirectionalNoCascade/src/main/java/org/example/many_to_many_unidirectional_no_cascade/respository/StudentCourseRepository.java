package org.example.many_to_many_unidirectional_no_cascade.respository;

import org.example.many_to_many_unidirectional_no_cascade.model.StudentCourse;
import org.example.many_to_many_unidirectional_no_cascade.model.StudentCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseKey> {

}
