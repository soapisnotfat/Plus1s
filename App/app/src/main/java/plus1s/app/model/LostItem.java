package plus1s.app.model;

import java.util.HashMap;

/**
 * Created by Catherine z.zhuang on 7/3/2017.
 */

public class LostItem {
    private static HashMap<String, Item> lostItem = new HashMap<>();

    /**
     * add reported item to lostItem
     * @param e Item parsing in
     */
    public static void addLostItem(Item e) {
        lostItem.put(e.getName(), e);
    }


    /**
     * get a string of all reported lost items
     * @return string of reported items
     */
    public HashMap<String, Item> getLostItems() {
        return lostItem;
    }
}

