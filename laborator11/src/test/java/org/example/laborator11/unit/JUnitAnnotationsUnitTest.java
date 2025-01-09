package org.example.laborator11.unit;

import org.junit.jupiter.api.*;

public class JUnitAnnotationsUnitTest {
    @BeforeEach
    public void setUp() {
        System.out.println("Before each method");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("After each method");
    }

    @BeforeAll
    public static void setUpOnce() {
        System.out.println("Before any test is run, and is run only once.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("After all tests are run, and is run only once.");
    }

    @Test
    public void testExampleOne_success() {
        //given

        //when
        System.out.println("In test method one.");

        //then
    }

    @Test
    public void testExampleTwo_success() {
        //given

        //when
        System.out.println("In test method two.");

        //then
    }

}
