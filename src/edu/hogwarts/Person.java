package edu.hogwarts;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Person() {}

    public Person(String fullName) {
        setFullName(fullName);
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (hasMiddleName()) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    public void setFullName(String fullName) {
        String[] nameParts = fullName.split(" ");

        firstName = nameParts[0];
        lastName = nameParts[nameParts.length - 1];

        if (nameParts.length > 2) {
            middleName = nameParts[1];
        }
    }

    public boolean hasMiddleName() {
        return middleName != null && !middleName.isEmpty();
    }

    public String toString() {
        return firstName + " " + middleName + " " + lastName;
    }
}

