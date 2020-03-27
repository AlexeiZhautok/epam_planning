package com.company;



public class Main {
    public static void main(String[] args) {
        ItemCollection test = new ItemCollection();
        ItemStream testStream = new  ItemStream(test);
        for(Item i : testStream.SortItemsByPrise()) {
            System.out.println(i);
        }
        testStream.PrintStoreForEach();
        for(Store i : testStream.GetStores()) {
            System.out.println(i);
        }
        System.out.println(testStream.GetStoresNoDublicates());

    }
}