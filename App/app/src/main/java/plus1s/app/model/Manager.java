package plus1s.app.model;

/**
 * Created by Ivorycandy on 6/28/17.
 * Manager class
 */

public class Manager extends User {
    public Manager() {
        super();
    }

    @Override
    public String getType() {
        return "Manager";
    }
}
