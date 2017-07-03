package plus1s.app.model;

import java.util.ArrayList;

/**
 * Created by Catherine z.zhuang on 7/3/2017.
 */

public class LostItem {
    private ArrayList<Item> lostItem = new ArrayList<>();

    /**
     * add reported item to lostItem
     * @param e Item parsing in
     */
    public void addLostItem(Item e) {
        lostItem.add(e);
    }


    /**
     * get a string of all reported lost items
     * @return string of reported items
     */
    public String getLostItemName() {
        String output = "";
        for (Item i: lostItem) {
            output += i.getName() + ",\n";
        }
        return output;
    }
}

