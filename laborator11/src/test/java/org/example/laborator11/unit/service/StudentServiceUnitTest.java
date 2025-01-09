package org.example.laborator11.unit.service;

import org.example.laborator11.exception.DuplicateStudentCnpException;
import org.example.laborator11.model.Address;
import org.example.laborator11.model.Student;
import org.example.laborator11.respository.AddressRepository;
import org.example.laborator11.respository.StudentRepository;
import org.example.laborator11.service.StudentService;
import org.example.laborator11.unit.test_service.MockStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceUnitTest {
    private MockStudentService mockStudentService = new MockStudentService();
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveStudent_success() throws DuplicateStudentCnpException {
        //given
        Student savedStudent = mockStudentService.getMockedStudent();

        Student newStudent = mockStudentService.getMockedStudent();
        newStudent.setId(null);
        newStudent.getAddress().setId(null);


        Mockito.when(addressRepository.save(newStudent.getAddress())).thenReturn(savedStudent.getAddress());
        //example with any() instead of student.getCnp()
        Mockito.when(studentRepository.findAllByCnp(Mockito.any())).thenReturn(new ArrayList<>());
        Mockito.when(studentRepository.save(newStudent)).thenReturn(savedStudent);

        //when
        Student testStudent = studentService.saveStudent(newStudent);

        //then
        Assertions.assertNotNull(testStudent.getId());
        Assertions.assertEquals(newStudent.getFirstName(), savedStudent.getFirstName());
        Assertions.assertEquals(newStudent.getLastName(), savedStudent.getLastName());
        Assertions.assertEquals(newStudent.getScore(), savedStudent.getScore());
        Assertions.assertEquals(newStudent.getCnp(), savedStudent.getCnp());
    }

    @Test
    public void testSaveStudent_throwsException()  throws DuplicateStudentCnpException{
        //given
        // any() example instead of an address object
        Student newStudent = mockStudentService.getMockedStudent();
        newStudent.setId(null);

        List<Student> dbStudent = List.of(mockStudentService.getMockedStudent());

        Mockito.when(addressRepository.save(Mockito.any())).thenReturn(new Address());
        Mockito.when(studentRepository.findAllByCnp(Mockito.any())).thenReturn(dbStudent);

        //when

        //then
        Assertions.assertThrows(DuplicateStudentCnpException.class,
                () -> studentService.saveStudent(newStudent));
    }
}
