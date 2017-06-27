package plus1s.app.model;

import java.util.ArrayList;

/**
 * Created by ivorycandy on 6/26/17.
 *
 */

public class FoundItem {
    private ArrayList<Item> foundItem = new ArrayList<>();

    /**
     * add reported item to foundItem
     * @param e Item parsing in
     */
    public void addFoundItem(Item e) {
        foundItem.add(e);
    }


    /**
     * get a string of all reported found items
     * @return string of reported items
     */
    public String getLostItemName() {
        String output = "";
        for (Item i: foundItem) {
            output += i.getName() + ",\n";
        }
        return output;
    }

}
