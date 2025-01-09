package org.example.laborator11.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import org.example.laborator11.controller.StudentController;
import org.example.laborator11.model.Student;
import org.example.laborator11.service.StudentService;
import org.example.laborator11.unit.test_service.MockStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

public class StudentControllerUnitTest {
    private MockStudentService mockStudentService = new MockStudentService();
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testGetStudents_success() throws Exception {
        // given
        List<Student> students = mockStudentService.getMockedStudents();
        Mockito.when(studentService.getStudents()).thenReturn(students);

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/student"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(new ObjectMapper().writeValueAsString(students)));
    }
}
