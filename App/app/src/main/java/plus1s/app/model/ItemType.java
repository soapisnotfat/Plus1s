package plus1s.app.model;

/**
 * Created by siyul on 7/3/2017.
 * enum obtaining all item types
 */

public enum ItemType {
    LOST("LOST"),
    FOUND("FOUND"),
    NEED("NEED");

    private String itemType;

    ItemType(String value) {itemType = value;}

    public String toString() {return itemType;}

}
