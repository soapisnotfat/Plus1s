package plus1s.app.model;

/**
 * Created by Ivorycandy on 6/28/17.
 *
 * Manager class
 */

public class Manager extends User {

    /**
     * non-param constructor inherited from User
     */
    public Manager() {
        super();
        this.type = AccountType.MANAGER.toString();
    }

    @Override
    public String returnType() {
        return "Manager";
    }
}
