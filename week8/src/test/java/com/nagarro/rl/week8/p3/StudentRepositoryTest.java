package com.nagarro.rl.week8.p3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class StudentRepositoryTest {

    private StudentRepository repo;

    private Student student;
    private Address address;

    @BeforeEach
    public void setup() throws IOException {
        repo = new StudentRepository("testFile.json");
        address = new Address("Cluj", "400000", "Baritiu");
        student = new Student(1, "Vlad", "Radu", new Date(2001, 10, 17), true, address);
    }

    @AfterEach
    public void cleanup() {
        File file = new File("testFile.json");
        file.delete();
    }

    @Test
    public void testSaveAndFindById() {
        // Act
        repo.save(student);
        Student result = repo.findById(1).orElse(null);

        // Assert
        Assertions.assertEquals(student, result);
    }

    @Test
    public void testFindAll() {
        // Arrange
        repo.save(student);

        // Act
        Iterable<Student> result = repo.findAll();

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.iterator().hasNext());
        Assertions.assertEquals(student, result.iterator().next());
    }

    @Test
    public void testDeleteById() {
        // Arrange
        repo.save(student);

        // Act
        repo.deleteById(1);
        Student result = repo.findById(1).orElse(null);

        // Assert
        Assertions.assertNull(result);
    }

    @Test
    public void testLoadStudentsFromFile() throws IOException {
        // Arrange
        File file = new File("testFile.json");
        file.createNewFile();
        repo.save(student);

        // Act
        repo = new StudentRepository("testFile.json");
        Iterable<Student> result = repo.findAll();

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.iterator().hasNext());
    }

    @Test
    public void testSaveStudentsToFile() {
        // Act
        repo.save(student);
        File file = new File("testFile.json");

        // Assert
        Assertions.assertTrue(file.exists() && file.length() > 0);
    }
}
