package plus1s.app.model;

/**
 * Created by ivorycandy on 6/26/17.
 * class obtaining item method
 */

public class Item {
    private String name;
    private String description;

    /**
     * two param constructor
     * @param name name parsing in
     * @param description description parsing in
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * one param constructor
     * @param name name parsing in
     */
    public Item(String name) {
        this(name, "");
    }

    /**
     * getter of name
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * getter of description
     * @return item description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter of name
     * @param name item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter of description
     * @param description item description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
