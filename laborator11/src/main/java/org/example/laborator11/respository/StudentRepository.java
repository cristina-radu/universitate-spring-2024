package org.example.laborator11.respository;

import org.example.laborator11.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByAgeBetween(Integer minLimit, Integer maxLimit);
    List<Student> findAllByAddress_City(String cityName);

    List<Student> findAllByCnp(String cnp);

    @Query(" from Student where score >= :score")
    List<Student> getStudentsWithScoreGreaterThanEquals(Float score);

    @Query(" select avg(score) from Student")
    Float getAvgScore();

    @Query(nativeQuery = true,
            value = " select avg(grade) from student ")
    Float getAvgScoreNative();

}
