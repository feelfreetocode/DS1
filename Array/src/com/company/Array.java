package com.company;
public class Array {
    private Integer[] items ;
    private Integer count = 0 ;
    Array(Integer initialSize){
        if(initialSize < 1){
            throw  new IllegalArgumentException("initial Size must be more than 0");
        }
        items = new Integer[initialSize];
    }

    public int indexOf(Integer item){
        for(int i = 0 ; i < count ; i ++ ){
            if(item == items[i]){
                return i ;
            }
        }
        return -1;
    }

    public int removeAt(int index){
        if(index< 0 || index > count){
            throw  new IllegalArgumentException("Invalid Index.");
        }
        int removedItem = items[index];

        for(int i= index ; i < count ; i ++){
            items[i] = items[i+1];
        }
        count--;
        return removedItem;
    }

    public void insert(Integer item ){
        if(count == items.length){
            Integer[] newArray = new Integer[count * 2];
            for(int i = 0 ; i < count ; i ++ ){
                newArray[i] = items[i];
            }
            items = newArray;
        }
        items[count++] = item;
    }

    public void print(){
        for(int i = 0 ; i < count ; i ++ ){
            System.out.println(items[i]);
        }
    }
}
