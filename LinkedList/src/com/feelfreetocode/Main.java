package com.feelfreetocode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
//        for (int i = 0; i <= 50; i += 10) {
//            list.addFirst(i);
//        }
        System.out.println(Arrays.toString(list.toArray()));
//        list.reverse();
//        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getValueAtKthIndexFromEnd(0));

    }
}
