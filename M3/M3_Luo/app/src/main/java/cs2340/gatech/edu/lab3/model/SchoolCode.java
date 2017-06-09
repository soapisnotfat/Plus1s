package cs2340.gatech.edu.lab3.model;

/**
 * Created by robertwaters on 1/5/17.
 *
 * This class represents the various school codes for registration
 */
public enum SchoolCode {
    CS ("Computer Science", "CS"),
    CM ("Computational Media", "CM"),
    IE ("Industrial Engineering", "IE"),
    EE ("Electrical Engineering", "EE"),
    MATH ("Mathematics", "MATH"),
    XX ("No Such School", "NULL"),
    AR ("Architecture", "AR");

    /** the full string representation of the course name */
    private final String name;

    /** the representation of the course name abbreviation - always at least 2 characters, but never more than 4*/
    private final String code;

    /**
     * Constructor for the enumeration
     *
     * @param pname   full name of the course
     * @param pcode   letter code / abbreviation for the course
     */
    SchoolCode(String pname, String pcode) {
        name = pname;
        code = pcode;
    }

    /**
     *
     * @return   the full course name
     */
    public String getName() { return name; }


    /**
     *
     * @return the abbreviation for the course
     */
    public String getCode() { return code; }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return code; }
}
