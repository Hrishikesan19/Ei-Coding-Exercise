
package virtualclassroom.Commands;
import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.Handlers.LoggerUtil;
public class RemoveClassroomCommand implements Command {
    private String name;
    public RemoveClassroomCommand(String name) { this.name = name; }
    @Override
public void execute() {
    boolean removed = VirtualClassroomManager.getInstance().removeClassroom(name);
    if (removed)
        LoggerUtil.log("Classroom " + name + " has been removed.");
    else
        LoggerUtil.log("Error: Classroom '" + name + "' not found.");
}

}
