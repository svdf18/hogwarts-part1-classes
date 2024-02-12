package edu.generic;

import edu.generic.Person;

public class Student extends Person {

    private int enrollmentYear;
    private int graduationYear;

    public Student(String firstName, String middleName, String lastName) {
        this(0, 0, firstName, middleName, lastName);
    }

    public Student(int enrollmentYear, int graduationYear, String firstName, String middleName, String lastName) {
        super(firstName, middleName, lastName);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
    }

    public Student(String fullName) {
        setFullName(fullName);
    }

    public Student(){};

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }
}
