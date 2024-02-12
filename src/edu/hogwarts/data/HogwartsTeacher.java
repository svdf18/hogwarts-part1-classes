package edu.hogwarts.data;

import edu.generic.Teacher;

import java.time.LocalDate;

public class HogwartsTeacher extends Teacher implements HogwartsPerson {

    private static int idCounter = 0;
    private int teacherId;
    private String house;
    private boolean headOfHouse;

    public HogwartsTeacher(String employment, LocalDate employmentStart, LocalDate employmentEnd, String firstName, String middleName, String lastName, String house, boolean headOfHouse) {
        super(employment, employmentStart, employmentEnd, firstName, middleName, lastName);
        this.teacherId = ++idCounter;
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public HogwartsTeacher() {
        this.teacherId = ++idCounter;
    }

    public HogwartsTeacher(HogwartsTeacher other) {
        super(other.getEmployment(), other.getEmploymentStart(), other.getEmploymentEnd(), other.getFirstName(), other.getMiddleName(), other.getLastName());
        this.teacherId = other.teacherId;
        this.house = other.house;
        this.headOfHouse = other.headOfHouse;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(boolean headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    public House linkToHouse() {
        return new House(house, "Unknown Founder", new String[]{});
    }
}
