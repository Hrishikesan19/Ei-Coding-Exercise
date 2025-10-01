package virtualclassroom.Exceptions;


public class AssignmentNotFoundException extends RuntimeException {
    public AssignmentNotFoundException(String title) { super("Assignment '" + title + "' not found."); }
}