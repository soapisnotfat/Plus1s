package plus1s.app.model;

/**
 * Created by Ivorycandy on 6/28/17.
 * administrator class
 */

public class Administrator extends User {
    public Administrator() {
        super();
        this.type = AccountType.ADMINISTRATOR.toString();
    }

    @Override
    public String returnType() {
        return "Administrator";
    }
}
