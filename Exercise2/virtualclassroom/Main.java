package virtualclassroom;

import java.util.Scanner;
import java.util.Collection;
import java.util.List;

import virtualclassroom.Commands.*;
import virtualclassroom.Exceptions.*;
import virtualclassroom.Handlers.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoggerUtil.log("----Exercise 2 - Virtual Classroom Manager----");
        printHelp();
        boolean go_on = true;
        while (go_on) {
            System.out.print("Enter Command: > ");
            String line = sc.nextLine().trim();
            line = line.trim().replaceAll("\\s+", " ");
            if (line.equalsIgnoreCase("help")) {
                printHelp();
                continue;
            }

            try {
                if (line.isEmpty())
                    continue;

                String[] parts = line.split(" ", 2);
                String cmd = parts[0].toLowerCase();

                switch (cmd) {
                    case "exit":
                        go_on = false;
                        break;
                    case "add_classroom":
                        handleAddClassroom(parts);
                        break;
                    case "remove_classroom":
                        handleRemoveClassroom(parts);
                        break;
                    case "list_classrooms":
                        listClassrooms();
                        break;
                    case "add_student":
                        handleAddStudent(parts);
                        break;
                    case "remove_student":
                        handleRemoveStudent(parts);
                        break;
                    case "list_students":
                        handleListStudents(parts);
                        break;
                    case "schedule_assignment":
                        handleScheduleAssignment(parts);
                        break;
                    case "remove_assignment":
                        handleRemoveAssignment(parts);
                        break;
                    case "list_assignments":
                        handleListAssignments(parts);
                        break;
                    case "submit_assignment":
                        handleSubmitAssignment(parts);
                        break;
                    case "pending_students":
                        handlePendingStudents(parts);
                        break;
                    default:
                        LoggerUtil.log("Unknown command. Type 'help' for available commands.");
                        break;
                }

            } catch (Exception e) {
                LoggerUtil.log("Error: " + e.getMessage());
            }
        }
        sc.close();
    }


    private static void handleAddClassroom(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: add_classroom <ClassName>");
            return;
        }
        String className = parts[1];
        TransientErrorHandler.retry(() -> new AddClassroomCommand(className).execute());
    }

    private static void handleRemoveClassroom(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: remove_classroom <ClassName>");
            return;
        }
        String className = parts[1];
        TransientErrorHandler.retry(() -> new RemoveClassroomCommand(className).execute());
    }

    private static void handleAddStudent(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: add_student <StudentID> <ClassName>");
            return;
        }
        String[] args = parts[1].split(" ", 2);
        if (args.length < 2) {
            LoggerUtil.log("Please provide both StudentID and ClassName.");
            return;
        }
        TransientErrorHandler.retry(() -> new AddStudentCommand(args[0], args[1]).execute());
    }

    private static void handleRemoveStudent(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: remove_student <StudentID> <ClassName>");
            return;
        }
        String[] args = parts[1].split(" ", 2);
        if (args.length < 2) {
            LoggerUtil.log("Please provide both StudentID and ClassName.");
            return;
        }
        TransientErrorHandler.retry(() -> new RemoveStudentCommand(args[0], args[1]).execute());
    }

    private static void handleListStudents(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: list_students <ClassName>");
            return;
        }
        listStudents(parts[1]);
    }

    private static void handleScheduleAssignment(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: schedule_assignment <ClassName> <AssignmentTitle>");
            return;
        }
        String[] args = parts[1].split(" ", 2);
        if (args.length < 2) {
            LoggerUtil.log("Please provide both ClassName and AssignmentTitle.");
            return;
        }
        TransientErrorHandler.retry(() -> new ScheduleAssignmentCommand(args[0], args[1]).execute());
    }

    private static void handleRemoveAssignment(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: remove_assignment <ClassName> <AssignmentTitle>");
            return;
        }
        String[] args = parts[1].split(" ", 2);
        if (args.length < 2) {
            LoggerUtil.log("Please provide both ClassName and AssignmentTitle.");
            return;
        }
        TransientErrorHandler.retry(() -> new RemoveAssignmentCommand(args[0], args[1]).execute());
    }

    private static void handleListAssignments(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: list_assignments <ClassName>");
            return;
        }
        listAssignments(parts[1]);
    }

    private static void handleSubmitAssignment(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: submit_assignment <StudentID> <ClassName> <AssignmentTitle>");
            return;
        }
        String[] args = parts[1].split(" ", 3);
        if (args.length < 3) {
            LoggerUtil.log("Please provide StudentID, ClassName, and AssignmentTitle.");
            return;
        }
        String studentId = args[0];
        String className = args[1];
        String assignmentTitle = args[2];
        TransientErrorHandler.retry(() -> new SubmitAssignmentCommand(studentId, className, assignmentTitle).execute());
    }

    private static void handlePendingStudents(String[] parts) {
        if (parts.length < 2) {
            LoggerUtil.log("Usage: pending_students <ClassName> <AssignmentTitle>");
            return;
        }
        String[] args = parts[1].split(" ", 2);
        if (args.length < 2) {
            LoggerUtil.log("Please provide both ClassName and AssignmentTitle.");
            return;
        }
        pendingStudents(args[0], args[1]);
    }

    private static void listClassrooms() {
        Collection<Classroom> classes = VirtualClassroomManager.getInstance().getAllClassrooms();
        if (classes.isEmpty())
            LoggerUtil.log("No classrooms found.");
        else
            for (Classroom c : classes)
                LoggerUtil.log(c.getName());
    }

    private static void listStudents(String className) {
        Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
        if (c == null) {
            LoggerUtil.log("Error: Classroom '" + className + "' not found.");
            return;
        }
        Collection<Student> students = c.getStudents();
        if (students.isEmpty())
            LoggerUtil.log("No students in " + className);
        else
            for (Student s : students)
                LoggerUtil.log(s.getId());
    }

    private static void listAssignments(String className) {
        Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
        if (c == null) {
            LoggerUtil.log("Error: Classroom '" + className + "' not found.");
            return;
        }
        Collection<Assignment> assignments = c.getAssignments();
        if (assignments.isEmpty())
            LoggerUtil.log("No assignments in " + className);
        else
            for (Assignment a : assignments)
                LoggerUtil.log(a.getTitle() + (a.isCompleted() ? " [Completed]" : ""));
    }

    private static void pendingStudents(String className, String title) {
        Classroom c = VirtualClassroomManager.getInstance().getClassroom(className);
        if (c == null) {
            LoggerUtil.log("Error: Classroom '" + className + "' not found.");
            return;
        }
        try {
            List<Student> pending = c.pendingStudents(title);
            if (pending.isEmpty())
                LoggerUtil.log("No pending students for '" + title + "' in " + className);
            else
                for (Student s : pending)
                    LoggerUtil.log(s.getId());
        } catch (AssignmentNotFoundException e) {
            LoggerUtil.log(e.getMessage());
        }

    }


    private static void printHelp() {
        System.out.println();
        System.out.println("Available Commands:");
        System.out.println("──────────────────────────────────────────────");
        System.out.println("    Classrooms");
        System.out.println("    • add_classroom <name>       → Add a new classroom");
        System.out.println("    • remove_classroom <name>    → Remove a classroom");
        System.out.println("    • list_classrooms            → List all classrooms");
        System.out.println();
        System.out.println("    Students");
        System.out.println("    • add_student <id> <class>      → Add a student to a classroom");
        System.out.println("    • remove_student <id> <class>   → Remove a student");
        System.out.println("    • list_students <class>         → List students in a classroom");
        System.out.println();
        System.out.println("    Assignments");
        System.out.println("    • schedule_assignment <class> <title> → Schedule a new assignment");
        System.out.println("    • remove_assignment <class> <title>   → Remove an assignment");
        System.out.println("    • list_assignments <class>           → List all assignments");
        System.out.println("    • submit_assignment <id> <class> <title> → Submit an assignment");
        System.out.println("    • pending_students <class> <title>   → View pending submissions");
        System.out.println();
        System.out.println("    Others");
        System.out.println("    • help  → Show this help menu");
        System.out.println("    • exit  → Quit the program");
        System.out.println("──────────────────────────────────────────────");
    }

}
