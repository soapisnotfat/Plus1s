package plus1s.app.model;

/**
 * Created by zijinluo on 6/28/17.
 * Enum holding account types
 */

public enum AccountType {
    ADMINISTRATOR("Administrator"),
    USER("User");

    private final String fullName;

    AccountType(String name) {
        this.fullName = name;
    }

    @Override
    public String toString() {
        return this.fullName;
    }

}
