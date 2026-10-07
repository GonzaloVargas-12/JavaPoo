package org.generation.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Course {
    private String courseName;
    private String courseId;
    private List<Student> enrolledStudents;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enroll(Student student) {
        enrolledStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // RETO EXTRA 1: Promedio
    public double calculateAverageGrade() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No hay estudiantes inscritos en este curso.");
            return 0.0;
        }

        double sum = 0.0;
        for (Student student : enrolledStudents) {
            sum += student.getGrade();
        }

        return sum / enrolledStudents.size();
    }

    // RETO EXTRA 2: Ranking
    public void outputRanking() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No hay estudiantes para mostrar en el ranking.");
            return;
        }

        List<Student> rankedList = new ArrayList<>(enrolledStudents);
        rankedList.sort(Comparator.comparingDouble(Student::getGrade).reversed());

        System.out.println("\n--- RANKING DEL CURSO: " + courseName + " ---");
        int rank = 1;
        for (Student student : rankedList) {
            System.out.printf("%d. %s (ID: %s) - Calificación: %.2f%n",
                    rank++, student.getName(), student.getId(), student.getGrade());
        }
    }

    // RETO EXTRA 3: Comparativa con promedio
    public void showStudentAverageComparison() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No hay estudiantes para comparar con el promedio.");
            return;
        }

        double courseAverage = calculateAverageGrade();
        System.out.printf("%n--- COMPARATIVA RESPECTO AL PROMEDIO DEL CURSO (%.2f) ---%n", courseAverage);

        for (Student student : enrolledStudents) {
            double grade = student.getGrade();
            if (grade > courseAverage) {
                System.out.printf("• %s (%.2f) -> Está POR ENCIMA del promedio.%n",
                        student.getName(), grade);
            } else if (grade < courseAverage) {
                System.out.printf("• %s (%.2f) -> Está POR DEBAJO del promedio.%n",
                        student.getName(), grade);
            } else {
                System.out.printf("• %s (%.2f) -> Es IGUAL al promedio.%n",
                        student.getName(), grade);
            }
        }
    }
}