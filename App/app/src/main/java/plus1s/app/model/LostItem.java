package plus1s.app.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Catherine z.zhuang on 7/3/2017.
 *
 * class obtaining all lost items
 */

public class LostItem {
    private final static HashMap<String, Item> lostItem = new HashMap<>();

    /**
     * add items to user's property
     *
     * @param name item's name
     * @param description item's description
     * @param category item's category
     * @param type item's type
     * @param reward item's reward amount
     * @param currentUsername item's uploader name
     * @param latitude item's latitude
     * @param longitude item's longitude
     */
    public static void addLostItem(String name, String description, String category, String type, int reward, String currentUsername, double latitude, double longitude) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        Item e = new Item(name, description, true, category, type, reward, formattedDate, currentUsername, latitude, longitude);
        lostItem.put(e.getName(), e);
    }

    /**
     * setter of lostItem
     *
     * @param e lostItem
     */
    public static void setLostItem(HashMap<String, Item> e) {
        lostItem.putAll(e);
    }

    /**
     * get a string of all reported lost items
     *
     * @return string of reported items
     */
    public static HashMap<String, Item> getLostItems() {
        return lostItem;
    }
}

