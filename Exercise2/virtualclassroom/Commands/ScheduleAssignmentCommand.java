package virtualclassroom.Commands;

import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.Classroom;
import virtualclassroom.Handlers.LoggerUtil;

public class ScheduleAssignmentCommand implements Command {
    private String className, assignmentTitle;
    public ScheduleAssignmentCommand(String className, String assignmentTitle) {
        this.className = className;
        this.assignmentTitle = assignmentTitle;
    }

    @Override
    public void execute() {
        Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
        if (c == null) {
            LoggerUtil.log("Classroom '" + className + "' not found.");
            return;
        }
        boolean added = c.addAssignment(assignmentTitle);
        if (added) LoggerUtil.log("Assignment '" + assignmentTitle + "' scheduled for " + className);
        else LoggerUtil.log("Assignment '" + assignmentTitle + "' already exists in " + className);
    }
}
