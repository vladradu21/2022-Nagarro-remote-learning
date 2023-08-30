package com.nagarro.rl.week8.p3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class StudentRepository implements StudentCrudRepository{

    private final Set<Student> students;
    private final ObjectMapper objectMapper;
    private final File file;

    public StudentRepository(String filePath) throws IOException {
        this.objectMapper = new ObjectMapper();
        this.file = new File(filePath);
        this.students = loadStudentsFromFile();
    }

    private Set<Student> loadStudentsFromFile() throws IOException {
        if (file.exists() && file.length() != 0) {
            return new HashSet<>(objectMapper.readValue(file, new TypeReference<>() {}));
        }
        return new HashSet<>();
    }

    @Override
    public Student save(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        students.add(student);
        saveStudentsToFile();
        return student;
    }

    @Override
    public Optional<Student> findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    @Override
    public Iterable<Student> findAll() {
        return students;
    }

    @Override
    public void deleteById(int id) {
        students.removeIf(student -> student.getId() == id);
        saveStudentsToFile();
    }

    private void saveStudentsToFile() {
        try {
            objectMapper.writeValue(file, students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
