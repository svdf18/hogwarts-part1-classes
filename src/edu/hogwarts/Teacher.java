package edu.hogwarts;

import java.time.LocalDate;

public class Teacher extends Person {

    private String employment;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public Teacher(String firstName, String middleName, String lastName) {
        this("Full Time", LocalDate.now(), LocalDate.now(), firstName, middleName, lastName);
    }

    public Teacher(String employment, LocalDate employmentStart, LocalDate employmentEnd, String firstName, String middleName, String lastName) {
        super(firstName, middleName, lastName);
        validateEmployment(employment);
        this.employment = employment;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher(String fullName) {
        setFullName(fullName);
    }

    public Teacher() {};

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        validateEmployment(employment);
        this.employment = employment;
    }

    // validator for 3 options: Full-time, Part-time, Substitute
    private void validateEmployment(String employment) {
        // Add logic to validate the employment value
        if (!"Full Time".equalsIgnoreCase(employment) && !"Part Time".equalsIgnoreCase(employment) && !"Substitute".equalsIgnoreCase(employment)) {
            throw new IllegalArgumentException("Invalid employment type. Valid values are Full Time, Part Time, and Substitute.");
        }
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd) {
        this.employmentEnd = employmentEnd;
    }
}
