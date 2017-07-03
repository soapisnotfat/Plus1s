package plus1s.app.model;

/**
 * Created by siyul on 7/3/2017.
 */

public enum ItemType {
    LOST("Lost"),
    FOUND("Found"),
    NEED("Need");
    private String itemType;
    ItemType(String value) {itemType = value;}
    public String getItemType() {return itemType;}

}
