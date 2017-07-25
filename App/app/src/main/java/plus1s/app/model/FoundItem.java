package plus1s.app.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Ivorycandy on 6/26/17.
 *
 * The class holding all found items
 */

public class FoundItem {
    private final static HashMap<String, Item> foundItem = new HashMap<>();

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
    public static void addFoundItem(String name, String description, String category, String type, int reward, String currentUsername, double latitude, double longitude) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        Item e = new Item(name, description, true, category, type, reward, formattedDate, currentUsername, latitude, longitude);
        foundItem.put(e.getName(), e);
    }

    /**
     * setter of foundItem
     *
     * @param e foundItem
     */
    public static void setFoundItem(HashMap<String, Item> e) {
        foundItem.putAll(e);
    }

    /**
     * get a string of all reported found items
     *
     * @return string of reported items
     */
    public static HashMap<String, Item> getFoundItems() {
        return foundItem;
    }
}
