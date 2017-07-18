package plus1s.app.model;

/**
 * Created by siyul on 7/3/2017.
 *
 * enum obtaining all item types
 */

public enum ItemType {
    LOST("LOST"),
    FOUND("FOUND"),
    NEED("NEED");

    private final String itemType;

    /**
     * one-param constructor setting item's type
     *
     * @param value item's type
     */
    ItemType(String value) {itemType = value;}

    @Override
    public String toString() {return itemType;}

}
