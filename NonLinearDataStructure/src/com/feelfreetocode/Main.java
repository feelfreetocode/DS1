package com.feelfreetocode;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(7);
        tree.add(4);
        tree.add(1);
        tree.add(6);
        tree.add(9);
        tree.add(8);
        tree.add(10);

        tree.inOrder();
        System.out.println("Valid Binary Search Tree : " + tree.isValidBinarySearchTree());
    }
}