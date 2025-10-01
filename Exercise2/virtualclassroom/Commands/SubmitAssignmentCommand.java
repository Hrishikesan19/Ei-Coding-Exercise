package virtualclassroom.Commands;
import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.Classroom;
import virtualclassroom.Student;
import virtualclassroom.Assignment;
import virtualclassroom.Exceptions.*;
import virtualclassroom.Handlers.LoggerUtil;
import virtualclassroom.Handlers.TransientErrorHandler;
public class SubmitAssignmentCommand implements Command {

    private String studentId;
    private String className;
    private String assignmentTitle;

    public SubmitAssignmentCommand(String studentId, String className, String assignmentTitle) {
        this.studentId = studentId;
        this.className = className;
        this.assignmentTitle = assignmentTitle;
    }

    @Override
    public void execute() {
        try {
            TransientErrorHandler.retry(() -> {
                Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
                if (c == null) throw new ClassroomNotFoundException(className);
    
                Student s = c.getStudent(studentId);
                if (s == null) throw new StudentNotFoundException(studentId); // permanent error
    
                Assignment a = c.getAssignment(assignmentTitle);
                if (a == null) throw new AssignmentNotFoundException(assignmentTitle);
    
                a.submit(s, c);
                LoggerUtil.log("Assignment '" + assignmentTitle + "' submitted by " + studentId);
            });
        } catch (StudentNotFoundException | ClassroomNotFoundException | AssignmentNotFoundException e) {
            LoggerUtil.log("Error: " + e.getMessage()); // log permanent error
        }
    }
    
}
