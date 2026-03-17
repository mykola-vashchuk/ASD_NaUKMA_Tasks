package PW_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentRegistry {
    private final List<Student> students = new ArrayList<>();
    private final Set<String> emails = new HashSet<>();
    private final Map<String, Student> studentMap = new HashMap<>();

    public boolean addStudent(Student student) {
        if (student == null || emails.contains(student.getEmail()) || studentMap.containsKey(student.getId())) {
            return false;
        }
        students.add(student);
        emails.add(student.getEmail());
        studentMap.put(student.getId(), student);
        return true;
    }

    public Student findById(String id) {
        return studentMap.get(id);
    }

    public boolean containsEmail(String email) {
        return emails.contains(email);
    }

    public void removeById(String id) {
        Student student = studentMap.remove(id);
        if (student != null) {
            emails.remove(student.getEmail());
            students.remove(student);
        }
    }
}
