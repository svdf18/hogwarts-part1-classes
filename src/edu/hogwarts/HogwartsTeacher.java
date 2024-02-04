package edu.hogwarts;

import java.time.LocalDate;

public class HogwartsTeacher extends Teacher implements HogwartsPerson {

    private String house;
    private boolean headOfHouse;

    public HogwartsTeacher(String employment, LocalDate employmentStart, LocalDate employmentEnd, String firstName, String middleName, String lastName, String house, boolean headOfHouse) {
        super(employment, employmentStart, employmentEnd, firstName, middleName, lastName);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public HogwartsTeacher() {};

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

    public void teach() {
        System.out.println(getFullName() + " is teaching.");
    }
}

