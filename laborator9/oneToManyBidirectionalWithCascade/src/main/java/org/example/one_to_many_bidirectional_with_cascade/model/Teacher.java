package org.example.one_to_many_bidirectional_with_cascade.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    /* Avoid Cascades for Shared Entities: If child entities are shared among multiple parents or
     independently managed, avoid cascading to prevent unintended deletions or updates.*/
    // If Bidirectional - Child Owns @JoinColumn and Parent with mappedBy)
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Department> departments = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartments(List<Department> departments) {
        this.departments.addAll(departments);
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
