class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollment {
    static final int courseCapacity = 2;
    static int enrolledStudents = 0;

    public static void enroll(String courseName, String prerequisiteStatus) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents >= courseCapacity) {
            throw new CourseFullException("CourseFullException - " + courseName + " is already full.");
        }

        if (prerequisiteStatus.equalsIgnoreCase("not completed")) {
            throw new PrerequisiteNotMetException("PrerequisiteNotMetException - Complete prerequisite before enrolling in " + courseName + ".");
        }

        enrolledStudents++;
        System.out.println("Enrollment successful in: " + courseName);
    }

    public static void main(String[] args) {
        try {
            enroll("Advanced Java", "not completed");
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            enroll("Advanced Java", "completed");
            enroll("Advanced Java", "completed");
            enroll("Advanced Java", "completed"); 
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
