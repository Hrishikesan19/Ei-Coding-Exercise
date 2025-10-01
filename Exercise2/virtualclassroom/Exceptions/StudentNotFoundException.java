package virtualclassroom.Exceptions;
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String id) { super("Student '" + id + "' not found."); }
}
