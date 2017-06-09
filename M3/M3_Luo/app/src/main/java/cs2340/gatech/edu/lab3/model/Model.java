package cs2340.gatech.edu.lab3.model;

import android.support.annotation.NonNull;
import android.support.compat.BuildConfig;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by robertwaters on 1/5/17.
 *
 * This is our facade to the Model.  We are using a Singleton design pattern to allow
 * access to the model from each controller.
 *
 *
 */

public class Model {
    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    /** holds the list of all courses */
    private List<Course> _courses;

    /** the currently selected course, defaults to first course */
    private Course _currentCourse;

    /** Null Object pattern, returned when no course is found */
    private final Course theNullCourse = new Course("No Such Course", "9999", SchoolCode.XX);


    /**
     * make a new model
     */
    public Model() {
        _courses = new ArrayList<>();

        //comment this out after full app developed
        loadDummyData();

    }

    /**
     * populate the model with some dummy data.  The full app would not require this.
     * comment out when adding new courses functionality is present.
     */
    private void loadDummyData() {
        _courses.add(new Course("Objects and Design", "2340", SchoolCode.CS));
        _courses.add(new Course( "TQM", "4321", SchoolCode.IE));
        _courses.add(new Course("Concrete Ideas", "5432", SchoolCode.AR));
        _courses.add(new Course("Calc I", "2213", SchoolCode.MATH));
        _courses.get(0).getStudents().add(new Student("Bob", "CS"));
        _courses.get(0).getStudents().add(new Student("Sally", "ISYE"));
        _courses.get(1).getStudents().add(new Student("Fred", "Math"));
        _courses.get(1).getStudents().add(new Student("Edith", "CM"));
        _currentCourse = _courses.get(0);
    }

    /**
     * get the courses
     * @return a list of the courses in the app
     */
    public List<Course> getCourses() { return _courses; }

    /**
     * add a course to the app.  checks if the course is already entered
     *
     * uses O(n) linear search for course
     *
     * @param course  the course to be added
     * @return true if added, false if a duplicate
     */
    public boolean addCourse(Course course) {
        for (Course c : _courses ) {
            if (c.equals(course)) return false;
        }
        _courses.add(course);
        return true;
    }

    /**
     *
     * @return  the currently selected course
     */
    public Course getCurrentCourse() { return _currentCourse;}

    public void setCurrentCourse(Course course) { _currentCourse = course; }

    /**
     * Return a course that has matching number.
     * This uses an O(n) linear search.
     *
     * @param number the number of the course to find
     * @return  the course with that number or the NullCourse if no such number exists.
     *
     */
    public Course getCourseByNumber (String number) {
        for (Course c : _courses ) {
            if (c.getNumber().equals(number)) return c;
        }
        return theNullCourse;
    }

    /**
     * Return a course that has the matching id
     * This uses a linear O(n) search
     *
     * @param id the id number of the course
     * @return the course with this id or theNullCourse if no such id exists.
     */
    public Course getCourseById(int id) {
        for (Course c : _courses ) {
            if (c.getId() == id) {
                return c;
            }
        }
        return theNullCourse;
    }

    /**
     * add a student to the current course
     *
     * @param student the student to add
     * @return true if student added, false if not added
     */
    public boolean addStudent(Student student) {
        return _currentCourse != null && _currentCourse.addStudent(student);
    }

    public void replaceStudentData(Student student) {
        Student existing = _currentCourse.findStudentById(student.getId());

        //if existing comes back null, something is seriously wrong
        if (BuildConfig.DEBUG && (existing == null)) { throw new AssertionError(); }

        existing.setName(student.getName());
        existing.setMajor(student.getMajor());
        existing.setClassStanding(student.getClassStanding());
    }
}
