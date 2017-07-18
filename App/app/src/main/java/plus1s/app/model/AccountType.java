package plus1s.app.model;

/**
 * Created by Ivorycandy on 6/28/17.
 *
 * Enum holding account types
 */

public enum AccountType {
    ADMINISTRATOR("Administrator"),
    MANAGER("Manager"),
    USER("User");

    private final String fullName;

    /**
     * one-param constructor setting name
     *
     * @param name name of the enum
     */
    AccountType(String name) {
        this.fullName = name;
    }

    @Override
    public String toString() {
        return this.fullName;
    }

}
