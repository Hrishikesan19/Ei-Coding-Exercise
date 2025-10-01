package virtualclassroom;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;


public class VirtualClassroomManager {
    private static VirtualClassroomManager instance = new VirtualClassroomManager();
    private Map<String, Classroom> classrooms = new HashMap<>();
    private VirtualClassroomManager() {}
    public static VirtualClassroomManager getInstance() { return instance; }

    public boolean addClassroom(String name) {
        if (classrooms.containsKey(name)) return false;
        classrooms.put(name, new Classroom(name));
        return true;
    }

    public boolean removeClassroom(String name) {
        if (classrooms.containsKey(name)) {
            classrooms.remove(name);
            return true;
        }
        return false;
    }
    

    public Classroom getClassroom(String name) { return classrooms.get(name); }

    public Collection<Classroom> getAllClassrooms() { return classrooms.values(); }
}