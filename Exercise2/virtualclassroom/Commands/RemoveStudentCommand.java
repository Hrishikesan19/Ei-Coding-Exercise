package virtualclassroom.Commands;

import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.Classroom;
import virtualclassroom.Handlers.LoggerUtil;

public class RemoveStudentCommand implements Command {
    private String studentId, className;
    public RemoveStudentCommand(String studentId, String className) { this.studentId = studentId; this.className = className; }
    

    @Override
public void execute() {
    Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
    if (c == null) {
        LoggerUtil.log("Error: Classroom '" + className + "' not found.");
        return;
    }

    boolean removed = c.removeStudent(studentId);
    if (removed)
        LoggerUtil.log("Student " + studentId + " removed from " + className + ".");
    else
        LoggerUtil.log("Error: Student " + studentId + " not found in " + className + ".");
}


}
