package exercise;

// Define class Teacher, subclass of AcademicPerson
public class Teacher extends AcademicPerson {
    // Instance variables
    private static final int MAX_COURSES = 10; // maximum courses

    // Constructor
    public Teacher(String name, String address) {
        super(name, address);
        courses = new String[MAX_COURSES];
    }


    // It adds a course into the list of courses.
    // This method throws ArrayElementException when the course that is being
    // added to the list already exists in it.
    public void addCourse(String course) throws ArrayElementException {
        for (int i = 0; i < courses.length; i++) {
            courses[i] = course;
        }
    }

    // It removes a course into the list of courses.
    // This method throws ArrayElementException when the course does not exist
    // in the list.
    public void removeCourse(String course) throws ArrayElementException {
        for (int i = 0; i < courses.length; i++) {
            courses[i] = null;
        }
    }

    // It prints all the courses in the list in each line
    @Override
    public void printCourses() {
        for (int i = 0; i < courses.length; i++) {
            System.out.print(courses[i]);
        }
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}
