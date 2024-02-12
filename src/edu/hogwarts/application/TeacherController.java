package edu.hogwarts.application;

import edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherController {

    private Map<Integer, HogwartsTeacher> teacherMap;
    private int lastId;

    public TeacherController() {
        teacherMap = new HashMap<>();
        lastId = 0;
    }

    public HogwartsTeacher createHogwartsTeacher(HogwartsTeacher receivedTeacher) {
        lastId++;

        HogwartsTeacher newTeacher = new HogwartsTeacher(
                receivedTeacher.getEmployment(),
                receivedTeacher.getEmploymentStart(),
                receivedTeacher.getEmploymentEnd(),
                receivedTeacher.getFirstName(),
                receivedTeacher.getMiddleName(),
                receivedTeacher.getLastName(),
                receivedTeacher.getHouse(),
                receivedTeacher.isHeadOfHouse()
        );


        newTeacher.setTeacherId(lastId);
        teacherMap.put(lastId, newTeacher);

        return newTeacher;
    }

    public List<HogwartsTeacher> getAllTeachers() {
        return new ArrayList<>(teacherMap.values());
    }

    public HogwartsTeacher getTeacher(int teacherId) {
        return teacherMap.get(teacherId);
    }

    public void updateTeacher(int teacherId, HogwartsTeacher updatedTeacher) {
        if (teacherMap.containsKey(teacherId)) {
            teacherMap.put(teacherId, updatedTeacher);
        }
    }

    public void deleteTeacher(int teacherId) {
        teacherMap.remove(teacherId);
    }
}
