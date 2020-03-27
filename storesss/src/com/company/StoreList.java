package com.company;

import java.util.ArrayList;

public class StoreList {
    private Store store_magnit = new Store("magnit");
    private Store store_7_11 = new Store("7/11");
    private Store store_5 = new Store("5");
    private Store store_smak = new Store("smak");
    private ArrayList<Store> store_one = new ArrayList<Store>(){
        {
            add(store_magnit);
        }
    };
    private ArrayList<Store> store_two = new ArrayList<Store>(){
        {
            add(store_magnit);
            add(store_7_11);
        }
    };
    private ArrayList<Store> store_tree = new ArrayList<Store>(){
        {
            add(store_magnit);
            add(store_7_11);
            add(store_5);
        }
    };
    private ArrayList<Store> store_fore = new ArrayList<Store>(){
        {
            add(store_magnit);
            add(store_7_11);
            add(store_5);
            add(store_smak);
        }
    };

    public ArrayList<Store> getStore_one() {
        return store_one;
    }

    public ArrayList<Store> getStore_two() {
        return store_two;
    }

    public ArrayList<Store> getStore_tree() {
        return store_tree;
    }

    public ArrayList<Store> getStore_fore() {
        return store_fore;
    }
}
