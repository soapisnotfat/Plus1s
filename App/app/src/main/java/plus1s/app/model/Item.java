package plus1s.app.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivorycandy on 6/26/17.
 *
 * class obtaining item method
 */

public class Item {
    private String name;
    private String description;
    private boolean status;
    private String category;
    private String type;
    private int reward;
    private String dateEntered;
    private String uploader;
    private double longitude;
    private double latitude;

    public final static List<ItemCategory> legalItemCategory = Arrays.asList(ItemCategory.KEEPSAKES, ItemCategory.HEIRLOOMS,
            ItemCategory.MISC);

    public final static List<ItemType> legalItemType = Arrays.asList(ItemType.FOUND, ItemType.LOST, ItemType.NEED);

    public final static List<String> searchList = new ArrayList<>();

    /**
     * two param constructor
     *
     * @param name name parsing in
     * @param description description parsing in
     */
    public Item(String name, String description, boolean status, String category,
                    String type, int reward, String dateEntered, String uploader, double latitude, double longitude) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.category = category;
        this.type = type;
        this.reward = reward;
        this.dateEntered = dateEntered;
        this.uploader = uploader;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * one-param constructor setting item's name
     *
     * @param name item's name putting in
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * non-param constructor
     */
    public Item() {}

    /**
     * getter of name
     *
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * getter of description
     *
     * @return item description
     */
    public String getDescription() {
        return description;
    }

    /**
     * getter of reward
     *
     * @return item reward
     */
    public int getReward() {
        return reward;
    }

    /**
     * getter of category
     *
     * @return item category
     */
    public String getCategory() {
        return category;
    }

    /**
     * getter of type
     *
     * @return item type
     */
    public String getType() {
        return type;
    }

    /**
     * getter of dateEntered
     *
     * @return item dateEntered
     */
    public String getDateEntered() {
        return dateEntered;
    }

    /**
     * getter of uploader
     *
     * @return item uploader
     */
    public String getUploader() {
        return uploader;
    }

    /**
     * getter of item's longitude
     *
     * @return item's longitude
     */
    public double getLongitude() {return longitude;}

    /**
     * getter of item's latitude
     *
     * @return item's latitude
     */
    public double getLatitude() {return latitude;}

    /**
     * setter of name
     *
     * @param name item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter of description
     *
     * @param description item description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * setter of category
     *
     * @param category item category
     */
    public void setCategory(ItemCategory category) {
        this.category = category.toString();
    }

    /**
     * setter of dateEntered
     *
     * @param dateEntered item dateEntered
     */
    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    /**
     * setter of reward
     *
     * @param reward item reward
     */
    public void setReward(int reward) {
        this.reward = reward;
    }

    /**
     * setter of status
     *
     * @param status item status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * setter of type
     *
     * @param type item type
     */
    public void setType(ItemType type) {
        this.type = type.toString();
    }

    /**
     * setter of uploader
     *
     * @param uploader item uploader
     */
    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    /**
     * setter of item's longitude
     *
     * @param longitude ite,'s longitude
     */
    public void setLongitude(double longitude) {this.longitude = longitude;}

    /**
     * setter of item's latitude
     *
     * @param latitude item's latitude
     */
    public void setLatitude(double latitude) {this.latitude = latitude;}
}
