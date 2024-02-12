package edu.hogwarts.application;
import edu.hogwarts.application.StudentController;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;
import java.time.LocalDate;

public class InitData {

    private StudentController studentController;
    private TeacherController teacherController;
    private boolean studentsInitialized;
    private boolean teachersInitialized;

    public InitData(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
        this.studentsInitialized = false;
        this.teachersInitialized = false;
    }

    public void initializeData() {
        if (!studentsInitialized) {
            initializeStudents();
            studentsInitialized = true;
        }

        if (!teachersInitialized) {
            initializeTeachers();
            teachersInitialized = true;
        }
    }

    public HogwartsStudent[] initializeStudents() {
        return new HogwartsStudent[]{
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Harry", "James", "Potter", "Gryffindor", true, new String[]{"Quidditch"})),
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Hermione", "Jean", "Granger", "Gryffindor", false, new String[]{"Study Group"})),
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Ron", "Bilius", "Weasley", "Gryffindor", false, new String[]{"Chess Club"})),
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Draco", "Lucius", "Malfoy", "Slytherin", true, new String[]{"Slytherin Quidditch Team"})),
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Luna", null, "Lovegood", "Ravenclaw", false, new String[]{"Ravenclaw Book Club"})),
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Cedric", "Ignatius", "Diggory", "Hufflepuff", false, new String[]{"Hufflepuff Prefects"})),
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Ginny", "Molly", "Weasley", "Gryffindor", false, new String[]{"Gryffindor Quidditch Team"})),
                studentController.createHogwartsStudent(new HogwartsStudent(1991, 1998, "Blaise", "Hyperion", "Zabini", "Slytherin", false, new String[]{"Slytherin Dueling Club"}))
        };
    }

    public HogwartsTeacher[] initializeTeachers() {
        return new HogwartsTeacher[]{
                teacherController.createHogwartsTeacher(new HogwartsTeacher("Full Time", LocalDate.of(1991, 9, 1), LocalDate.of(2000, 6, 30), "Severus", "Prince", "Snape", "Slytherin", true)),
                teacherController.createHogwartsTeacher(new HogwartsTeacher("Full Time", LocalDate.of(1995, 9, 1), LocalDate.of(2002, 6, 30), "Horace", null, "Slughorn", "Slytherin", false))
        };
    }
}
