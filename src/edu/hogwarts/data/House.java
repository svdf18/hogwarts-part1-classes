package edu.hogwarts.data;

import java.util.Arrays;

public class House {
    private String name;
    private String founder;
    private String[] colors;

    // Valid house names
    private static final String[] VALID_HOUSES = {"Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"};

    public House(String name, String founder, String[] colors) {
        validateHouseName(name);
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateHouseName(name);
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    private void validateHouseName(String name) {
        if (!Arrays.asList(VALID_HOUSES).contains(name)) {
            throw new IllegalArgumentException("Invalid house name. Valid values are Gryffindor, Ravenclaw, Slytherin, and Hufflepuff.");
        }
    }

    public String toString() {
        return "Name: " + name + ", Founder: " + founder + ", Colors: " + Arrays.toString(colors);
    }
}
