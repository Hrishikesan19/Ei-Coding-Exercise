
package virtualclassroom.Exceptions;
public class ClassroomNotFoundException extends RuntimeException {
    public ClassroomNotFoundException(String name) { super("Classroom '" + name + "' not found."); }
}
