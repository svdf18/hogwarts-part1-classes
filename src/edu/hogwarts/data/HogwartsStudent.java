package edu.hogwarts.data;

import edu.generic.Student;
import java.util.Arrays;

public class HogwartsStudent extends Student implements HogwartsPerson {

    private static int idCounter = 0;
    private int studentId;
    private String house;
    private boolean prefect;
    private String[] teams;

    public HogwartsStudent(int enrollmentYear, int graduationYear, String firstName, String middleName, String lastName, String house, boolean prefect, String[] teams) {
        super(enrollmentYear, graduationYear, firstName, middleName, lastName);
        this.studentId = ++idCounter;
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }
    public HogwartsStudent() {};

    public HogwartsStudent(HogwartsStudent other) {
        super(other.getEnrollmentYear(), other.getGraduationYear(), other.getFirstName(), other.getMiddleName(), other.getLastName());
        this.studentId = other.studentId;
        this.house = other.house;
        this.prefect = other.prefect;
        this.teams = Arrays.copyOf(other.teams, other.teams.length);
    }

    public HogwartsStudent(String firstName) {
        super(0, 0, firstName, null, null);
        this.studentId = 0;
        this.house = null;
        this.prefect = false;
        this.teams = null;
    }



    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public House linkToHouse() {
        return new House(house, "Unknown Founder", new String[]{});
    }
}