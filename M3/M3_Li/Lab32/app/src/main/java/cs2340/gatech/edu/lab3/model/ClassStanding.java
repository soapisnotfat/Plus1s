package cs2340.gatech.edu.lab3.model;

/**
 * Created by siyul on 6/8/2017.
 */
public enum ClassStanding {
    FR("FRESHMAN"),
    SO("SOPHOMORE"),
    JR("JUNIOR"),
    SR("SENIOR");
    private String classStandings;
    ClassStanding(String value) {
        classStandings = value;
    }
    public String getStandings() {
        return classStandings;
    }

}
