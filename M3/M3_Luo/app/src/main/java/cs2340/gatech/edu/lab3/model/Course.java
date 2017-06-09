package cs2340.gatech.edu.lab3.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by robertwaters on 8/12/16.
 *
 * Represents a single Course which may have many students assigned
 *
 * Information Holder and Structurer (manages the students assigned to the course
 */
public class Course {
    private static int nextNo = 1;

    /** unique id number */
    private int _id;

    /** the course name */
    private String _name;

    /** the course number */
    private String _number;

    /** the school code for the course */
    private SchoolCode _school;

    /** the list of all registered students for this course */
    private  List<Student> _students;

    /**
     * Makes a new Course
     * @param name  the name of the course like "Calc 2"
     * @param number the number of the course
     * @param school the code for the school like CS
     */
    public Course(String name, String number, SchoolCode school) {
        _name = name;
        _number = number;
        _school = school;
        _id = Course.nextNo++;
        _students = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        Course c = (Course) o;
        return (c.getName().equals(_name) && c.getNumber().equals(_number));
    }

    /* *****************************************
     * All the property setters and getters
     * */
    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    public int getId() { return _id; }

    public String getNumber() { return _number; }
    public void setNumber(String number) { _number = number; }

    public SchoolCode getSchool() { return _school; }
    public void setSchool(SchoolCode school) {  _school = school; }

    public List<Student> getStudents() {return _students; }

    /* ********************************************
     * Instance Methods
     */

    /**
     * Adds the requested student.  If student is already in the class, return false
     * This is an O(n) search
     *
     * This assumes all student names are unique
     *
     * @param student   the student to add to the course
     * @return true if success, false if student already in the class
     */
    public boolean addStudent(Student student) {

        //go through each student looking for duplicate name   O(n)
        for (Student s : _students) {
            if (s.getName().equals(student.getName())) {
                //oops found duplicate name, don't add and return failure signal
                return false;
            }
        }
        //never found the name so safe to add it.
        _students.add(student);
        //return the success signal
        return true;
    }

    @Override
    public String toString() {
        return _school.toString() + _number + " " + _name;
    }

    /**
     * Finds a student using O(n) linear search given a unique id number
     * @param id
     * @return
     */
    public Student findStudentById(int id) {
        for (Student s : _students) {
            if (id == s.getId()) {
                return s;
            }
        }
        return null;
    }
}

