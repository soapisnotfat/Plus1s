package plus1s.app.model;

/**
 * Created by siyul on 7/3/2017.
 */

public enum ItemCategory {
    KEEPSAKES("KEEPSAKES"),
    HEIRLOOMS("HEIRLOOMS"),
    MISC("MISC");
    private String categories;
    ItemCategory (String value) {categories = value;}
    public String getCategories() {return categories;}
}
