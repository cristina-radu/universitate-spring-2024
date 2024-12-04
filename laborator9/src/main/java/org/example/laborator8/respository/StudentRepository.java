package org.example.laborator8.respository;

import org.example.laborator8.model.Student;
import org.example.laborator8.service.StudentService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private String url = "jdbc:mysql://localhost:3306/school";
    private String user = "root";
    private String password = "root";

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
        ) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
                student.setScore(resultSet.getFloat("score"));
                student.setCnp(resultSet.getString("cnp"));
                students.add(student);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return students;
    }


    public void saveStudent(Student student) {
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO student (first_name, last_name, age, score, cnp) " +
                                "VALUES (?, ?, ?, ?, ?)")
        ) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setFloat(4, student.getScore());
            preparedStatement.setString(5, student.getCnp());
            int rowNo = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

/*

delimiter //
        CREATE PROCEDURE insertStudent(OUT id int,
          IN firstName varchar(30), IN lastName varchar(30), IN age int, IN score float, cnp varchar(30))
        BEGIN
        INSERT INTO student(first_name, last_name, age, score, cnp) VALUES (firstName, lastName, age, score, cnp);
        SET id = LAST_INSERT_ID();
        END //
        delimiter ;
*/


    public Student executeProcedure(Student student){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            CallableStatement cs = connection.prepareCall("{call insertStudent(?, ?, ?, ?, ?, ?)}");
            cs.setString(2, student.getFirstName());
            cs.setString(3, student.getLastName());
            cs.setInt(4, student.getAge());
            cs.setFloat(5, student.getScore());
            cs.setString(6, student.getCnp());

            cs.registerOutParameter(1, Types.INTEGER);

            cs.execute();
            student.setId(cs.getInt(1));
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return student;
    }


}
