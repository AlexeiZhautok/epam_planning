package com.company;

public class Main {
    public static void main(String[] args) {
        ItemCollection test = new ItemCollection();
        ItemStream testStream = new  ItemStream(test);

        ItemCollection2 test2 = new ItemCollection2();
        ItemStream2 testStream2 = new  ItemStream2(test2);

//        System.out.print(testStream.SinglStoreItem()+"\n");
        System.out.print(testStream.SinglStoreItem()+"\n");




//        testStream.FindMaxCount();
        System.out.print(testStream2.SinglStoreItemNonParallel()+"\n");
//        testStream.PriceOverThen(500);
//        testStream.SinglStoreItem();
//        for(Item i : testStream.SortItemsByPrise()) {
//            System.out.println(i);
//        }
//        testStream.PrintStoreForEach();
//        for(Store i : testStream.GetStores()) {
//            System.out.println(i);
//        }
//        System.out.println(testStream.GetAllStores());

    }
}