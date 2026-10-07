package org.generation;

import org.generation.model.Course;
import org.generation.model.Student;

public class Main {
    public static void main(String[] args) {
        Course mathCourse = new Course("MATH101", "Matemáticas Básicas");

        Student student1 = new Student("S1", "Alice", 95.0);
        Student student2 = new Student("S2", "Bob", 70.0);
        Student student3 = new Student("S3", "Charlie", 85.5);
        Student student4 = new Student("S4", "Diana", 60.0);

        mathCourse.enroll(student1);
        mathCourse.enroll(student2);
        mathCourse.enroll(student3);
        mathCourse.enroll(student4);

        double average = mathCourse.calculateAverageGrade();
        System.out.printf("El promedio del curso es: %.2f%n", average);

        mathCourse.outputRanking();

        mathCourse.showStudentAverageComparison();
    }
}