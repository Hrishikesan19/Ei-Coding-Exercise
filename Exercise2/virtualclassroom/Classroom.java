package virtualclassroom;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import virtualclassroom.Exceptions.AssignmentNotFoundException;


public class Classroom {
    private String name;
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Assignment> assignments = new HashMap<>();

    public Classroom(String name) { this.name = name; }
    public String getName() { return name; }

    public boolean enrollStudent(String studentId) {
        if (students.containsKey(studentId)) return false;
        students.put(studentId, new Student(studentId));
        return true;
    }

    public boolean removeStudent(String studentId) {
        if (students.containsKey(studentId)) {
            students.remove(studentId);
            return true;
        }
        return false;
    }
    

    public Collection<Student> getStudents() { return students.values(); }
    public Student getStudent(String id) { return students.get(id); }

    public boolean addAssignment(String title) {
        if (assignments.containsKey(title)) return false;
        assignments.put(title, new Assignment(title));
        return true;
    }

    public boolean removeAssignment(String title) {
        if (assignments.containsKey(title)) {
            assignments.remove(title);
            return true;
        }
        return false;
    }
    public Collection<Assignment> getAssignments() { return assignments.values(); }
    public Assignment getAssignment(String title) { return assignments.get(title); }

    public List<Student> pendingStudents(String title) {
        Assignment a = assignments.get(title);
        if (a == null) throw new AssignmentNotFoundException(title);
    
        List<Student> pending = new ArrayList<>();
        for (Student s : students.values()) {
            if (!a.hasStudentSubmitted(s)) pending.add(s);
        }
        return pending;
    }
    
    

    public void checkAndMarkCompleted(String title) {
        Assignment a = assignments.get(title);
        if (a == null) return;
    
        boolean allSubmitted = true;
        for (Student s : students.values()) {
            if (!a.hasStudentSubmitted(s)) {
                allSubmitted = false;
                break;
            }
        }
    
        if (allSubmitted) a.markCompleted();
    }
    
}