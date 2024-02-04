package edu.hogwarts;

import java.time.LocalDate;

public class Application {

    private static HogwartsStudent[] hogwartsStudents;
    private static HogwartsTeacher[] hogwartsTeachers;
    private static House[] houses;

    public static void main(String[] args) {
        initApp();

        //Had to define TeachingMaterials before the method-call..
        Wand wand = new Wand("Wand", true, true, false, "Some notes", 12.5, "Oak", "Dragon Heartstring");
        TextBook textBook = new TextBook("Book", true, true, false, "Some more notes", "'Advanced Potion-Making'", "Libatius Borage", "Merge Books", 1946 );
        Tool tool = new Tool("Tool", true,true,false, "It's a spoon..", "Cauldron", "Small silver spoon");
        Ingredient sopophorousBean = new Ingredient("Sopophorous bean", true, true, false, "Some notes", "Sopophorous bean", 7, "units");
        Ingredient slothBrain = new Ingredient("Sloth brain", true, true, false, "Some notes", "Sloth brain", 69, "grams");
        Ingredient powderedRootOfAsphodel = new Ingredient("Powdered Root of Asphodel", true, true, false, "Some notes", "Powdered Root of Asphodel", 7, "ounces");

        //Method-call to start a new course - had to use student index instead of name to get it to work.
        startCourse("Horace Slughorn", "Potions", 6, false, new TeachingMaterial[]{textBook, tool, sopophorousBean, slothBrain}, 3, 4, 1);
    }

    //Init students, teachers and houses
    public static void initApp() {
        hogwartsStudents = new HogwartsStudent[]{
                new HogwartsStudent(1991, 1998, "Harry", "James", "Potter", "Gryffindor", true, new String[]{"Quidditch"}),
                new HogwartsStudent(1991, 1998, "Hermione", "Jean", "Granger", "Gryffindor", false, new String[]{"Study Group"}),
                new HogwartsStudent(1991, 1998, "Ron", "Bilius", "Weasley", "Gryffindor", false, new String[]{"Chess Club"}),
                new HogwartsStudent(1991, 1998, "Draco", "Lucius", "Malfoy", "Slytherin", true, new String[]{"Slytherin Quidditch Team"}),
                new HogwartsStudent(1991, 1998, "Luna", null, "Lovegood", "Ravenclaw", false, new String[]{"Ravenclaw Book Club"}),
                new HogwartsStudent(1991, 1998, "Cedric", "Ignatius", "Diggory", "Hufflepuff", false, new String[]{"Hufflepuff Prefects"}),
                new HogwartsStudent(1991, 1998, "Ginny", "Molly", "Weasley", "Gryffindor", false, new String[]{"Gryffindor Quidditch Team"}),
                new HogwartsStudent(1991, 1998, "Blaise", "Hyperion", "Zabini", "Slytherin", false, new String[]{"Slytherin Dueling Club"})
        };
        hogwartsTeachers = new HogwartsTeacher[]{
                new HogwartsTeacher("Full Time", LocalDate.of(1991, 9, 1), LocalDate.of(2000, 6, 30), "Severus", "Prince", "Snape", "Slytherin", true),
                new HogwartsTeacher("Full Time", LocalDate.of(1995, 9, 1), LocalDate.of(2002, 6, 30), "Horace", null, "Slughorn", "Slytherin", false)
        };

        houses = new House[]{
                new House("Gryffindor", "Godric Gryffindor", new String[]{"Red", "Gold"}),
                new House("Slytherin", "Salazar Slytherin", new String[]{"Green", "Silver"}),
                new House("Ravenclaw", "Rowena Ravenclaw", new String[]{"Blue", "Bronze"}),
                new House("Hufflepuff", "Helga Hufflepuff", new String[]{"Yellow", "Black"})
        };

        // Init yearGroup
        YearGroup yearGroup6 = new YearGroup(6, LocalDate.of(1991, 9, 1));

        for (HogwartsStudent student : hogwartsStudents) {
            if (student.getEnrollmentYear() == 1991) {
                yearGroup6.addStudent(student);
            }
        }

        // Print yearGroup6 (all students for now)
        yearGroup6.displayInfo();

    }

    // Method to print students by house
    public static void outputStudentsInHouse(String houseName) {
        System.out.println("Students in " + houseName + ":");
        for (HogwartsStudent student : hogwartsStudents) {
            House studentHouse = student.linkToHouse();
            if (studentHouse.getName().equals(houseName)) {
                System.out.println("- " + student);
            }
        }
    }

    // Method to print teachers by house
    public static void outputTeachersInHouse(String houseName) {
        System.out.println("Teachers in " + houseName + ":");
        for (HogwartsTeacher teacher : hogwartsTeachers) {
            House teacherHouse = teacher.linkToHouse();
            if (teacherHouse.getName().equals(houseName)) {
                System.out.println("- " + teacher);
            }
        }
    }

    // Get teacher by name to start new course
    public static HogwartsTeacher getTeacherByName(String teacherName) {
        for (HogwartsTeacher teacher : hogwartsTeachers) {
            if (teacher.getFullName().equals(teacherName)) {
                return teacher;
            }
        }
        return null; // Return null if the teacher is not found
    }

    // Method to start a new course
    public static void startCourse(String teacherName, String subjectName, int schoolYear, boolean elective, TeachingMaterial[] teachingMaterials, int... studentIndexes) {
        HogwartsTeacher courseTeacher = getTeacherByName(teacherName);

        Subject newSubject = new Subject(subjectName, schoolYear, elective);

        HogwartsStudent[] courseStudents = new HogwartsStudent[studentIndexes.length];
        for (int i = 0; i < studentIndexes.length; i++) {
            int index = studentIndexes[i];
            if (index >= 0 && index < hogwartsStudents.length) {
                courseStudents[i] = hogwartsStudents[index];
            } else {
                System.out.println("Invalid student index: " + index);
                return;
            }
        }

        Course newCourse = new Course(newSubject, courseTeacher, courseStudents);

        // Add teaching materials to the course
        for (TeachingMaterial teachingMaterial : teachingMaterials) {
            newCourse.addTeachingMaterial(teachingMaterial);
        }

        newCourse.startCourse();
    }
}
