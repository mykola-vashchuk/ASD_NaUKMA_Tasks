package PW_8;

import java.util.HashSet;
import java.util.Set;

public class StudentService {
    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();

        Student s1 = new Student("1", "max@gmail.com", "Max");
        Student s2 = new Student("2", "ivan@gmail.com", "Ivan");
        Student s3 = new Student("3", "max@gmail.com", "Oleg");

        System.out.println("Add s1: " + registry.addStudent(s1)); // true
        System.out.println("Add s2: " + registry.addStudent(s2)); // true
        System.out.println("Add s3: " + registry.addStudent(s3)); // false email is already exists

        System.out.println();
        System.out.println("Find by id=1: " + registry.findById("1").getName());
        System.out.println("Contains email max@gmail.com: " + registry.containsEmail("max@gmail.com")); // true

        System.out.println();
        registry.removeById("1");
        System.out.println("Remove id=1: виконано");

        System.out.println("Find by id=1 after remove: " + registry.findById("1")); // null
        System.out.println("Contains email max@gmail.com after remove: " + registry.containsEmail("max@gmail.com")); // false

        System.out.println();
        Student s4 = new Student("4", "max@gmail.com", "Andrii");
        System.out.println("Add s4 with reused email: " + registry.addStudent(s4)); // true

        System.out.println();
        System.out.println("//-------- Завдання 4 --------");
        Set<Student> students = new HashSet<>();

        Student s11 = new Student("1", "max11111@gmail.com", "Max11111");
        Student s12 = new Student("1", "other@gmail.com", "DuplicateID"); // Однаковий ID = 1

        System.out.println("Add s11: " + students.add(s11)); // true
        System.out.println("Add s12 (same ID): " + students.add(s12)); // false
        System.out.println("HashSet size: " + students.size()); // 1
    }
}
