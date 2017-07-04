package plus1s.app.model;

import java.util.HashMap;

/**
 * Created by Ivorycandy on 6/26/17.
 * The class holding all found items
 */

public class FoundItem {
    private static HashMap<String, Item> foundItem = new HashMap<>();

    /**
     * add reported item to foundItem
     *
     * @param e Item parsing in
     */
    public static void addFoundItem(Item e) {
        foundItem.put(e.getName(), e);
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
