package com.example.nooraakhtar.listview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noora.Akhtar on 04/04/2016.
 */
public class StoreCheckNavigationDrawerItem {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static List<StoreCheckNavigationDrawerItem> getData() {
        List<StoreCheckNavigationDrawerItem> dataList = new ArrayList<>();

        String[] titles = getTitles();

        for (int i = 0; i < titles.length; i++) {
            StoreCheckNavigationDrawerItem navItem = new StoreCheckNavigationDrawerItem();
            navItem.setTitle(titles[i]);

            dataList.add(navItem);
        }
        return dataList;
    }



    private static String[] getTitles() {

        return new String[] {
                "View Details", "Add Brand", "Add Outlet", "Import Store-Check data", "Export Store-Check data"
        };
    }
}
