# Virtual Classroom Manager

**Overview**  
The Virtual Classroom Manager is a terminal-based application designed to simplify the management of virtual classrooms. Educators can efficiently create classrooms, enroll students, schedule assignments, and track submissions, all through simple commands.

---

## Features

**Classroom Management:**  
- Create, remove, and list virtual classrooms.  

**Student Enrollment:**  
- Add or remove students in specific classrooms.  

**Assignment Management:**  
- Schedule and remove assignments for classrooms.  
- Submit assignments on behalf of students.  
- Track pending submissions.  

**Classroom Details:**  
- View enrolled students, scheduled assignments, and submission status for each classroom.

## Design Patterns and Principles

* **Singleton Pattern:** Ensures a single instance of `VirtualClassroomManager`, centralizing classroom management.
* **Command Pattern:** Encapsulates user actions (like adding classrooms, enrolling students, submitting assignments) as separate command objects for scalability and maintainability.

---
## List Of Commands
<img width="606" height="441" alt="Screenshot 2025-10-01 at 2 51 24 PM" src="https://github.com/user-attachments/assets/7ad7ed7d-82c6-45b4-a514-fced466b16f0" />

## Example Run
<img width="502" height="467" alt="Screenshot 2025-10-01 at 2 59 56 PM" src="https://github.com/user-attachments/assets/f9e32de4-db05-4b51-9a0f-79be2ada3e87" />


---

## Edge Cases Handled

- Adding a student that already exists in the same classroom.


- Listing classrooms when none are available.
<img width="502" height="406" alt="Screenshot 2025-10-01 at 3 01 24 PM" src="https://github.com/user-attachments/assets/6115aca4-ddbc-4de9-99fe-d4389e548db3" />
   
- Scheduling an assignment to a non existant classroom.
<img width="336" height="38" alt="Screenshot 2025-10-01 at 3 02 32 PM" src="https://github.com/user-attachments/assets/99894155-e501-4992-8eed-3f0d619a1bb1" />
    
- Duplicate enrolling of a student in a classroom.
<img width="262" height="81" alt="Screenshot 2025-10-01 at 3 03 58 PM" src="https://github.com/user-attachments/assets/f12642ba-92be-43f6-a7ea-a195fda2ed46" />

- Removing non-existent students or assignments.
<img width="309" height="36" alt="Screenshot 2025-10-01 at 3 05 12 PM" src="https://github.com/user-attachments/assets/962493f8-682e-440b-9baa-bf31365a8f0f" />
<img width="309" height="36" alt="Screenshot 2025-10-01 at 3 05 43 PM" src="https://github.com/user-attachments/assets/c5715865-625f-4cc0-a810-622f9a620acd" />

- Submitting an assignment that hasn’t been scheduled.  
<img width="486" height="124" alt="Screenshot 2025-10-01 at 3 06 18 PM" src="https://github.com/user-attachments/assets/4052f0f9-b509-4702-beae-5e007a3c2ceb" />

- Trailing spaces
<img width="356" height="113" alt="Screenshot 2025-10-01 at 3 07 30 PM" src="https://github.com/user-attachments/assets/bf80e884-0567-4536-87ce-aebadbdbc8e8" />

---

## Available Commands

**Classrooms**  
- `add_classroom <name>` → Add a new classroom  
- `remove_classroom <name>` → Remove a classroom  
- `list_classrooms` → List all classrooms  

**Students**  
- `add_student <id> <class>` → Add a student to a classroom  
- `remove_student <id> <class>` → Remove a student from a classroom  
- `list_students <class>` → List students in a classroom  

**Assignments**  
- `schedule_assignment <class> <title>` → Schedule a new assignment  
- `remove_assignment <class> <title>` → Remove an assignment  
- `list_assignments <class>` → List all assignments in a classroom  
- `submit_assignment <id> <class> <title>` → Submit an assignment  
- `pending_students <class> <title>` → View pending submissions  

**Others**  
- `help` → Show this help menu  
- `exit` → Quit the program  

---
