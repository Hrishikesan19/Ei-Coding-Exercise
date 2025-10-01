package virtualclassroom.Commands;
import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.Classroom;
import virtualclassroom.Handlers.LoggerUtil;

public class AddStudentCommand implements Command {
    private String studentId, className;
    public AddStudentCommand(String studentId, String className) {
        this.studentId = studentId; this.className = className;
    }

    @Override
    public void execute() {
        Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
        if (c == null) {
            LoggerUtil.log("Classroom '" + className + "' not found.");
            return;
        }
        boolean enrolled = c.enrollStudent(studentId);
        if (enrolled) LoggerUtil.log("Student " + studentId + " has been enrolled in " + className);
        else LoggerUtil.log("Student " + studentId + " already enrolled in " + className);
    }
}
