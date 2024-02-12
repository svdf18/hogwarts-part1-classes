package edu.hogwarts.application;

import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {

    private StudentController studentController;
    private TeacherController teacherController;
    private HogwartsStudent[] hogwartsStudents;
    private HogwartsTeacher[] hogwartsTeachers;

    public UserInterface(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
        this.hogwartsStudents = new HogwartsStudent[0];  // Initialize the arrays
        this.hogwartsTeachers = new HogwartsTeacher[0];
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose sorting option:");
            System.out.println("a - Alphabetical");
            System.out.println("id - By ID");
            System.out.println("h - By House");
            System.out.println("q - Quit");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "a":
                    sortAndPrintAlphabetical();
                    break;
                case "id":
                    sortAndPrintById();
                    break;
                case "h":
                    sortAndPrintByHouse();
                    break;
                case "q":
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void sortAndPrintAlphabetical() {
        hogwartsStudents = studentController.getAllStudents().toArray(new HogwartsStudent[0]);
        hogwartsTeachers = teacherController.getAllTeachers().toArray(new HogwartsTeacher[0]);

        Arrays.sort(hogwartsStudents, Comparator.comparing(HogwartsStudent::getFullName));
        Arrays.sort(hogwartsTeachers, Comparator.comparing(HogwartsTeacher::getFullName));

        System.out.println("Sorted Students Alphabetically:");
        for (HogwartsStudent student : hogwartsStudents) {
            System.out.println("Name: " + student.getFullName());
            System.out.println("-----");
        }

        System.out.println("Sorted Teachers Alphabetically:");
        for (HogwartsTeacher teacher : hogwartsTeachers) {
            System.out.println("Name: " + teacher.getFullName());
            System.out.println("ID: " + teacher.getTeacherId());
            System.out.println("House: " + teacher.getHouse());
            System.out.println("-----");
        }
    }

    private void sortAndPrintById() {
        hogwartsStudents = studentController.getAllStudents().toArray(new HogwartsStudent[0]);
        hogwartsTeachers = teacherController.getAllTeachers().toArray(new HogwartsTeacher[0]);

        Arrays.sort(hogwartsStudents, Comparator.comparing(HogwartsStudent::getStudentId));
        Arrays.sort(hogwartsTeachers, Comparator.comparing(HogwartsTeacher::getTeacherId));

        System.out.println("Sorted Students by ID:");
        for (HogwartsStudent student : studentController.getAllStudents()) {
            System.out.println("Name: " + student.getFullName());
            System.out.println("ID: " + student.getStudentId());
            System.out.println("House: " + student.getHouse());
            System.out.println("-----");
        }

        System.out.println("Sorted Teachers by ID:");
        for (HogwartsTeacher teacher : teacherController.getAllTeachers()) {
            System.out.println("Name: " + teacher.getFullName());
            System.out.println("ID: " + teacher.getTeacherId());
            System.out.println("House: " + teacher.getHouse());
            System.out.println("-----");
        }
    }

    private void sortAndPrintByHouse() {
        hogwartsStudents = studentController.getAllStudents().toArray(new HogwartsStudent[0]);
        hogwartsTeachers = teacherController.getAllTeachers().toArray(new HogwartsTeacher[0]);

        Arrays.sort(hogwartsStudents, Comparator.comparing(HogwartsStudent::getHouse)
                .thenComparing(HogwartsStudent::getFullName));
        Arrays.sort(hogwartsTeachers, Comparator.comparing(HogwartsTeacher::getHouse)
                .thenComparing(HogwartsTeacher::getFullName));

        String currentHouse = null;

        System.out.println("Sorted Students and Teachers by House:");

        for (HogwartsStudent student : hogwartsStudents) {
            if (!student.getHouse().equals(currentHouse)) {
                currentHouse = student.getHouse();
                System.out.println("\nHouse: " + currentHouse);
            }
            System.out.println("Name: " + student.getFullName());
            System.out.println("-----");
        }

        currentHouse = null;

        for (HogwartsTeacher teacher : hogwartsTeachers) {
            if (!teacher.getHouse().equals(currentHouse)) {
                currentHouse = teacher.getHouse();
                System.out.println("\nHouse: " + currentHouse);
            }
            System.out.println("Name: " + teacher.getFullName());
            System.out.println("ID: " + teacher.getTeacherId());
            System.out.println("-----");
        }
    }

}
