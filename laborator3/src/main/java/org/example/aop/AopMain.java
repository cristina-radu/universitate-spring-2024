package org.example.aop;

import org.example.aop.config.ApplicationConfigFive;
import org.example.aop.service.StudentService;
import org.example.aop.service.TeacherService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfigFive.class);
        StudentService studentService = applicationContext.getBean(StudentService.class);
        studentService.getAllStudents();

        TeacherService teacherService = applicationContext.getBean(TeacherService.class);
        teacherService.getAllTeachers();
        teacherService.getTeacherById();
        teacherService.getTeacherName();
        studentService.getStudentById();
    }
}