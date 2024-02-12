package edu.hogwarts.application;

import edu.hogwarts.data.HogwartsStudent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class StudentController {

    private Map<Integer, HogwartsStudent> studentMap;
    private int lastId;

    public StudentController() {
        studentMap = new HashMap<>();
        lastId = 0;
    }

    public HogwartsStudent createHogwartsStudent(HogwartsStudent receivedStudent) {
        lastId++;

        HogwartsStudent newStudent = new HogwartsStudent(
                receivedStudent.getEnrollmentYear(),
                receivedStudent.getGraduationYear(),
                receivedStudent.getFirstName(),
                receivedStudent.getMiddleName(),
                receivedStudent.getLastName(),
                receivedStudent.getHouse(),
                receivedStudent.isPrefect(),
                receivedStudent.getTeams()
        );

        newStudent.setStudentId(lastId);
        studentMap.put(lastId, newStudent);

        return newStudent;
    }

    public HogwartsStudent getStudent(int studentId) {
        return studentMap.get(studentId);
    }

    public List<HogwartsStudent> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public void updateStudent(int id, HogwartsStudent updatedStudent) {
        if (studentMap.containsKey(id)) {
            HogwartsStudent existingStudent = studentMap.get(id);
            existingStudent.setEnrollmentYear(updatedStudent.getEnrollmentYear());
            existingStudent.setGraduationYear(updatedStudent.getGraduationYear());
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setMiddleName(updatedStudent.getMiddleName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setHouse(updatedStudent.getHouse());
            existingStudent.setPrefect(updatedStudent.isPrefect());
            existingStudent.setTeams(updatedStudent.getTeams());
        }
    }

    public void deleteStudent(int id) {
        studentMap.remove(id);
    }
}
