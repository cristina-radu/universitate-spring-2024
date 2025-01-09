package org.example.laborator11.unit.test_service;

import org.example.laborator11.model.Address;
import org.example.laborator11.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockStudentService {

    public Student getMockedStudent() {
        Student student = new Student();
        student.setId(12);
        student.setFirstName("Mihai");
        student.setLastName("Popescu");
        student.setAge(21);
        student.setScore(8.5f);
        student.setCnp("5463789046");
        student.setAddress(getMockedAddress());
        return student;
    }

    public Address getMockedAddress() {
        Address address = new Address();
        address.setId(23);
        address.setCity("Bucharest");
        address.setStreet("Blv Unirii");
        address.setStreetNo("26");
        return address;
    }

    public List<Student> getMockedStudents() {
        return List.of(getMockedStudent());
    }
}
