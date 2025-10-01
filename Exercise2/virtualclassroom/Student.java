package virtualclassroom;

import java.util.Set;
import java.util.HashSet;

public class Student {
    private String id;
    private Set<String> submittedAssignments = new HashSet<>();

    public Student(String id) { this.id = id; }
    public String getId() { return id; }

    public boolean submit(String assignmentTitle) { return submittedAssignments.add(assignmentTitle); }
    public boolean hasSubmitted(String assignmentTitle) { return submittedAssignments.contains(assignmentTitle); }
}
