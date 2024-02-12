package edu.hogwarts.data;

public class Course {
    private Subject subject;
    private HogwartsTeacher teacher;
    private HogwartsStudent[] students;
    private TeachingMaterial[] teachingMaterials;


    public Course(Subject subject, HogwartsTeacher teacher, HogwartsStudent[] students) {
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
        this.teachingMaterials = new TeachingMaterial[0];

    }

    public Course() {};

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public HogwartsTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(HogwartsTeacher teacher) {
        this.teacher = teacher;
    }

    public HogwartsStudent[] getStudents() {
        return students;
    }

    public void setStudents(HogwartsStudent[] students) {
        this.students = students;
    }

    public TeachingMaterial[] getTeachingMaterials() {
        return teachingMaterials;
    }

    public void addTeachingMaterial(TeachingMaterial teachingMaterial) {
        TeachingMaterial[] newTeachingMaterials = new TeachingMaterial[teachingMaterials.length + 1];
        System.arraycopy(teachingMaterials, 0, newTeachingMaterials, 0, teachingMaterials.length);
        newTeachingMaterials[teachingMaterials.length] = teachingMaterial;
        teachingMaterials = newTeachingMaterials;
    }

    public void startCourse() {
        System.out.println("Course started: " + subject.getName() + ", " + "Year: " + subject.getSchoolYear()  + ", " + "Elective: " + subject.isElective());
        System.out.println("Taught by: " + teacher.getFullName());

        System.out.println("Enrolled students:");
        for (HogwartsStudent student : students) {
            System.out.println("- " + student.getFullName());
        }

        System.out.println("Teaching Materials:");
        for (TeachingMaterial teachingMaterial : teachingMaterials) {
            System.out.println("- " + teachingMaterial);
        }
    }
}