package org.example.laborator9.service;

import org.example.laborator9.exception.DuplicateStudentCnpException;
import org.example.laborator9.model.Address;
import org.example.laborator9.model.Student;
import org.example.laborator9.respository.AddressRepository;
import org.example.laborator9.respository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final AddressRepository addressRepository;
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @Transactional(rollbackFor = {DuplicateStudentCnpException.class})
    public void saveStudent(Student student) throws DuplicateStudentCnpException {
        Address address = addressRepository.save(student.getAddress());
        if (studentRepository.findAllByCnp(student.getCnp()).size() > 0) {
            throw new DuplicateStudentCnpException("Student with cnp "+ student.getCnp() + " already exists in db.");
        }
        studentRepository.save(student);
    }

    public List<Student> getStudentsWithAgeBetween(Integer minLimit, Integer maxLimit){
        return studentRepository.findAllByAgeBetween(minLimit, maxLimit);
    }

    public List<Student> getStudentsWithScoreGreaterThanEquals(Float score) {
        return studentRepository.getStudentsWithScoreGreaterThanEquals(score);
    }

    public Float getAvgScore() {
        return studentRepository.getAvgScore();
    }

    public Float getAvgScoreNative() {
        return studentRepository.getAvgScoreNative();
    }
}
