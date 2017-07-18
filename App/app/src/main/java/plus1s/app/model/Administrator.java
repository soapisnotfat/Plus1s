package plus1s.app.model;

/**
 * Created by Ivorycandy on 6/28/17.
 *
 * Class obtaining administrator info
 */

public class Administrator extends User {

    /**
     * non-param constructor inherited from User
     */
    public Administrator() {
        super();
        this.type = AccountType.ADMINISTRATOR.toString();
    }

    @Override
    public String returnType() {
        return "Administrator";
    }
}
