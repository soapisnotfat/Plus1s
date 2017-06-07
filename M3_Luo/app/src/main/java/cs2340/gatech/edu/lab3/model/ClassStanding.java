package cs2340.gatech.edu.lab3.model;

/**
 * Created by zijinluo on 6/7/17.
 */

public enum ClassStanding {
    FR("FRESHMAN"),
    SO("SOPHOMORE"),
    JR("JUNIOR"),
    SR("SENIOR");

    private String value;

    ClassStanding(String vas) {
        value = vas;
    }

    public String getFull() {
        return value;
    }
}
