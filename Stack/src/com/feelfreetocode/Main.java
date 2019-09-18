package com.feelfreetocode;
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        String s = "[12+56 + {45 * 65} * (56+89)]";
        boolean flag = stack.validateExpression(s);
        System.out.println(flag);
    }
}




