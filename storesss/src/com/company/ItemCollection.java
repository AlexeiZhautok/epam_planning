package com.company;

import java.util.ArrayList;
import java.util.List;

public class ItemCollection {
    private ArrayList<Item> collection = new ArrayList<>();
    private StoreList sl = new StoreList();





    public ItemCollection() {

        collection.add(new Item("Ris", 100, 100, sl.getStore_one()));
        collection.add(new Item( "Grechka", 200, 200, sl.getStore_two()));
        collection.add(new Item( "Divan", 1000, 3, sl.getStore_tree()));
        collection.add(new Item( "Stul", 450, 15, sl.getStore_fore()));
    }

    public ArrayList<Item> getArray() {
        return collection;
    }


}