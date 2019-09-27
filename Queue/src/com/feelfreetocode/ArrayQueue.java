package com.feelfreetocode;

import java.util.Arrays;

public class ArrayQueue {
    private int[] data ;
    private int rear = 0;
    private  int front = 0;
    private int size = 0;

    public ArrayQueue(){
        data = new int[5];
    }

    public void enqueue(Integer item){
        if(size == data.length )
            throw new IllegalStateException("Queue is Full...");

        data[rear % data.length] = item;
        rear++;
        size++;
    }

    public Integer dequeue(){

        if(size == 0)
            throw new IllegalStateException("Queue is Empty...");
        Integer item = data[front % data.length];
        data[front % data.length] = 0;
        front ++;
        size--;
        return item;
    }
    public Integer peek(){
        return data[front];
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
