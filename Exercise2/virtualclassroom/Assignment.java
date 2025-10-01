package virtualclassroom;


import java.util.Set;
import java.util.HashSet;



public class Assignment {
    private String title;
    private boolean completed;
    private Set<String> submittedStudentIds = new HashSet<>();

    public Assignment(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void submit(Student s, Classroom classroom) {
        if (completed) return;

        submittedStudentIds.add(s.getId());

        // all students in the class submitted check
        boolean allSubmitted = classroom.getStudents().stream()
                .allMatch(student -> submittedStudentIds.contains(student.getId()));

        if (allSubmitted) {
            markCompleted();
        }
    }

    public boolean hasStudentSubmitted(Student s) {
        return submittedStudentIds.contains(s.getId());
    }

    public void markCompleted() {
        completed = true;
    }
}
