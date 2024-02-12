package edu.hogwarts.application;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;
import java.time.LocalDate;

public class Application {

    private StudentController studentController;
    private TeacherController teacherController;
    private HogwartsStudent[] hogwartsStudents;
    private HogwartsTeacher[] hogwartsTeachers;
    private UserInterface userInterface;

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    public void start() {
        studentController = new StudentController();
        teacherController = new TeacherController();
        userInterface = new UserInterface(studentController, teacherController);


        InitData initData = new InitData(studentController, teacherController);
        hogwartsStudents = initData.initializeStudents();
        hogwartsTeachers = initData.initializeTeachers();

        userInterface.start();

//        //Calls for CRUD DEMOS
//        //Print initial students' information
//        System.out.println("Initial Hogwarts Students Information:");
//        printStudentsInfo();
//
//        demoCreateStudent();
//
//        //
//        System.out.println("Updated Hogwarts Students Information:");
//        printStudentsInfo();
//
//        demoDeleteStudent();
//
//        System.out.println("Updated Hogwarts Students Information:");
//        printStudentsInfo();
//
//        demoGetStudentById();
//
//        demoUpdateStudentById();
//
//        System.out.println("Updated Hogwarts Students Information:");
//        printStudentsInfo();
//
//        demoCreateTeacher();
//        printTeachersInfo();

      //PRINTS and METHODS for CRUD DEMOS
//    private void printStudentsInfo() {
//        System.out.println("Hogwarts Students Information:");
//        System.out.println("+------------+");
//        for (HogwartsStudent student : hogwartsStudents) {
//            System.out.println("Name: " + student.getFullName());
//            System.out.println("-----");
//        }
//    }
//
//    private void printTeachersInfo() {
//        System.out.println("Hogwarts Teachers Information:");
//        System.out.println("+------------+");
//        for (HogwartsTeacher teacher : hogwartsTeachers) {
//            System.out.println("Name: " + teacher.getFullName());
//            System.out.println("ID: " + teacher.getTeacherId());
//            System.out.println("House: " + teacher.getHouse());
//            System.out.println("-----");
//        }
//    }
//
//    private void demoCreateStudent() {
//        HogwartsStudent newStudent = new HogwartsStudent(1991, 1998, "Neville", "Frank", "Longbottom", "Gryffindor", false, new String[]{"Herbology"});
//        HogwartsStudent createdStudent = studentController.createHogwartsStudent(newStudent);
//        System.out.println("Created Student: " + createdStudent.getFullName());
//
//        hogwartsStudents = studentController.getAllStudents().toArray(new HogwartsStudent[0]);
//    }
//
//    private void demoDeleteStudent(){
//        int studentIdToDelete = 8;
//        studentController.deleteStudent(studentIdToDelete);
//        System.out.println("Deleted Student with ID " + studentIdToDelete);
//
//        hogwartsStudents = studentController.getAllStudents().toArray(new HogwartsStudent[0]);
//    }
//
//    private void demoGetStudentById(){
//        int studentIdToRetrieve = 9;
//
//        HogwartsStudent retrievedStudent = studentController.getStudent(studentIdToRetrieve);
//
//        if (retrievedStudent != null) {
//            System.out.println("Retrieved Student: " + retrievedStudent.getFullName());
//            System.out.println("Retrieved Student ID: " + retrievedStudent.getStudentId());
//            System.out.println("House: " + retrievedStudent.getHouse());
//            System.out.println("-----");
//        } else {
//            System.out.println("Student with ID " + studentIdToRetrieve + " not found.");
//        }
//    }
//
//    private void demoUpdateStudentById(){
//        int studentIdToUpdate = 4;
//        HogwartsStudent updatedStudent = new HogwartsStudent(1991, 1998, "Updated", "Updated", "Updated", "Gryffindor", false, new String[]{"Updated Team"});
//        studentController.updateStudent(studentIdToUpdate, updatedStudent);
//        System.out.println("Updated Student: " + updatedStudent.getFullName());
//        System.out.println("Updated Student ID: " + updatedStudent.getStudentId());
//    }
//
//    private void demoCreateTeacher() {
//        HogwartsTeacher newTeacher1 = new HogwartsTeacher("Full Time", LocalDate.of(1991, 9, 1), LocalDate.of(2000, 6, 30), "Minerva", "McGonagall", "McGonagall", "Gryffindor", true);
//        HogwartsTeacher createdTeacher1 = teacherController.createHogwartsTeacher(newTeacher1);
//        System.out.println("Created Teacher: " + createdTeacher1.getFullName() + " with ID: " + createdTeacher1.getTeacherId());
//
//        HogwartsTeacher newTeacher2 = new HogwartsTeacher("Full Time", LocalDate.of(1995, 9, 1), LocalDate.of(2002, 6, 30), "Filius", null, "Flitwick", "Ravenclaw", false);
//        HogwartsTeacher createdTeacher2 = teacherController.createHogwartsTeacher(newTeacher2);
//        System.out.println("Created Teacher: " + createdTeacher2.getFullName() + " with ID: " + createdTeacher2.getTeacherId());
//
//        hogwartsTeachers = teacherController.getAllTeachers().toArray(new HogwartsTeacher[0]);
//    }

    }
}
