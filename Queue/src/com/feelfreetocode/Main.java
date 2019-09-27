package com.feelfreetocode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(11);
        System.out.println(queue);
        queue.enqueue(12);
        System.out.println(queue);
        queue.enqueue(13);
        System.out.println(queue);
        queue.enqueue(14);
        System.out.println(queue);
        System.out.println(queue);
        queue.enqueue(15);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(11);
        System.out.println(queue);
        queue.enqueue(12);
        System.out.println(queue);
        queue.enqueue(13);
        System.out.println(queue);
        queue.enqueue(14);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();

        System.out.println(queue);
    }

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        System.out.println(queue);
    }
}
