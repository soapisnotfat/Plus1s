package plus1s.app.model;

/**
 * Created by siyul on 7/3/2017.
 *
 * enum obtaining all item categories
 */

public enum ItemCategory {
    KEEPSAKES("KEEPSAKES"),
    HEIRLOOMS("HEIRLOOMS"),
    MISC("MISC");

    private final String categories;

    /**
     * one-param constructor setting name of enum
     *
     * @param value name of enum
     */
    ItemCategory (String value) {categories = value;}

    @Override
    public String toString() {return categories;}
}
