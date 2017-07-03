package plus1s.app.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivorycandy on 6/26/17.
 * class obtaining item method
 */

public class Item {
    private String name;
    private String description;
    private String location;
    private boolean status;
    private ItemCategory category;
    private ItemType type;
    private int reward;
    private String dateEntered;
    private Account uploader;

    public static List<ItemCategory> legalItemCategory= Arrays.asList(ItemCategory.KEEPSAKES, ItemCategory.HEIRLOOMS,
            ItemCategory.MISC
    );

    /**
     * two param constructor
     * @param name name parsing in
     * @param description description parsing in
     */
    public Item(String name, String description, String location, boolean status, ItemCategory category,
                    ItemType type, int reward, String dateEntered, Account uploader) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.status = status;
        this.category = category;
        this.type = type;
        this.reward = reward;
        this.dateEntered = dateEntered;
        this.uploader = uploader;
    }

    /**
     * non-param constructor
     */
    public Item() {}

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
     * getter of reward
     * @return item reward
     */
    public int getReward() {
        return reward;
    }

    /**
     * getter of category
     * @return item category
     */
    public ItemCategory getCategory() {
        return category;
    }

    /**
     * getter of type
     * @return item type
     */
    public ItemType getType() {
        return type;
    }

    /**
     * getter of dateEntered
     * @return item dateEntered
     */
    public String getDateEntered() {
        return dateEntered;
    }

    /**
     * getter of location
     * @return item location
     */
    public String getLocation() {
        return location;
    }

    /**
     * getter of uploader
     * @return item uploader
     */
    public Account getUploader() {
        return uploader;
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

    /**
     * setter of category
     * @param category item category
     */
    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    /**
     * setter of dateEntered
     * @param dateEntered item dateEntered
     */
    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    /**
     * setter of location
     * @param location item location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * setter of reward
     * @param reward item reward
     */
    public void setReward(int reward) {
        this.reward = reward;
    }

    /**
     * setter of status
     * @param status item status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * setter of type
     * @param type item type
     */
    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * setter of uploader
     * @param uploader item uploader
     */
    public void setUploader(Account uploader) {
        this.uploader = uploader;
    }
}
