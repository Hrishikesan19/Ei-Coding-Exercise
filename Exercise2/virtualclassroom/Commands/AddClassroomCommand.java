package virtualclassroom.Commands;
import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.Handlers.LoggerUtil;

public class AddClassroomCommand implements Command {
    private String className;
    public AddClassroomCommand(String className) { this.className = className; }

    @Override
    public void execute() {
        boolean added = VirtualClassroomManager.getInstance().addClassroom(className);
        if (added) LoggerUtil.log("Classroom " + className + " has been created.");
        else LoggerUtil.log("Classroom " + className + " already exists.");
    }
}
