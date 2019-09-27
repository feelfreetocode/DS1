package com.feelfreetocode;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Entry>[] table;
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(12 , "twelve");
        hashTable.put(15 , "fifteen");
        hashTable.put(5, "five");

        System.out.println(hashTable.get(12));
    }

    public HashTable() {
        table = new LinkedList[10];
    }

    private  class Entry{
        private Integer key ;
        private String value;

        Entry(Integer key ,String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " -> " +value;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Entry)
                return this.key.equals(((Entry)obj).key);
            return false;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public void put(Integer key , String value){
        Entry entry = getEntry(key);
        if(entry != null)
            entry.value = value;
        else
            getOrCreateBucket(hash(key)).add(new Entry(key , value));
    }

    public String get(Integer key){
       Entry entry = getEntry(key);
       return (entry!=null) ? entry.value : null ;
    }

    private int hash(Integer key) {
        return key % table.length;
    }

    private Entry getEntry(Integer key){
        int index = hash(key);
        LinkedList<Entry> bucket = getBucket(index);
        if(bucket != null) {
            Entry tempEntry = new Entry(key, null);
            int entryIndex = bucket.indexOf(tempEntry);
            return (entryIndex < 0) ? null : bucket.get(entryIndex);
        }

        return null;
    }

    public void remove(Integer key){

    }

    private LinkedList<Entry> getBucket(int index){
        return table[index];
    }

    private LinkedList<Entry> getOrCreateBucket(int index){
        LinkedList<Entry> bucket = table[index];
        if(bucket == null){
            bucket = new LinkedList<>();
            table[index] = bucket;
        }
        return bucket;
    }

    public void show(){
        for(LinkedList<Entry> chain : table){
            System.out.println(chain);
        }
    }
}
