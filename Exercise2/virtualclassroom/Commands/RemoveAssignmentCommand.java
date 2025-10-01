package virtualclassroom.Commands;
import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.Classroom;
import virtualclassroom.Handlers.LoggerUtil;

public class RemoveAssignmentCommand implements Command {
    private String className, title;
    public RemoveAssignmentCommand(String className, String title) { this.className = className; this.title = title; }
    @Override
public void execute() {
    Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
    if (c == null) {
        LoggerUtil.log("Error: Classroom '" + className + "' not found.");
        return;
    }

    boolean removed = c.removeAssignment(title);
    if (removed)
        LoggerUtil.log("Assignment '" + title + "' removed from " + className + ".");
    else
        LoggerUtil.log("Error: Assignment '" + title + "' not found in " + className + ".");
}

}

