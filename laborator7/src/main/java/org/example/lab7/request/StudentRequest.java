package org.example.lab7.request;

import jakarta.validation.constraints.*;

public class StudentRequest {
    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    @NotNull(message = "Last name is mandatory")
    private String lastName;
    @NotNull(message = "Age is mandatory")
    private Integer age;
    @NotNull(message = "Score is mandatory")
    @Min(value = 1, message = "Score must have value of at least 1")
    @Max(value = 10, message = "Score must have value of max 10")
    private Float score;
    @NotNull(message = "Cnp is mandatory")
    @Size(min = 10, max=10, message = "Cnp should be of size 10.")
    @Pattern(regexp = "^[0-9]*$", message = "Cnp should have only numbers.")
    private String cnp;

    public StudentRequest(String firstName, String lastName, Integer age, Float score, String cnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.score = score;
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Float getScore() {
        return score;
    }

    public String getCnp() {
        return cnp;
    }
}
