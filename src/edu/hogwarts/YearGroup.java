package edu.hogwarts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class YearGroup {
    private int schoolYear;
    private LocalDate beginningOfSchoolYear;
    // Test of arraylist to get dynamic resizing.
    private List<HogwartsStudent> students;

    public YearGroup(int schoolYear, LocalDate beginningOfSchoolYear) {
        this.schoolYear = schoolYear;
        this.beginningOfSchoolYear = beginningOfSchoolYear;
        this.students = new ArrayList<>();
    }

    public YearGroup() {};

    // Getters and Setters
    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public LocalDate getBeginningOfSchoolYear() {
        return beginningOfSchoolYear;
    }

    public void setBeginningOfSchoolYear(LocalDate beginningOfSchoolYear) {
        this.beginningOfSchoolYear = beginningOfSchoolYear;
    }

    public List<HogwartsStudent> getStudents() {
        return students;
    }

    public void setStudents(List<HogwartsStudent> students) {
        this.students = students;
    }

    // Add student to the year group
    public void addStudent(HogwartsStudent student) {
        students.add(student);
    }

    public void displayInfo() {
        System.out.println("Year Group: " + schoolYear);
        System.out.println("Beginning of School Year: " + beginningOfSchoolYear);

        System.out.println("Students in Year Group:");
        for (HogwartsStudent student : students) {
            System.out.println("- " + student.getFullName());
        }
    }
}
