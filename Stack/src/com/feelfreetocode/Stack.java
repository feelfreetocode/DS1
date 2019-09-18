package com.feelfreetocode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack {
    private Object[] stack;
    private int count = 0;

    public Stack() {
        stack = new Object[10];
    }

    public void push(Object item) {
        if (count == stack.length)
            throw new StackOverflowError();
        stack[count++] = item;
    }

    public Object pop() {
        if (count == 0)
            throw new IllegalStateException();
        return stack[--count];
    }


    public Object peek() {
        if (count == 0)
            throw new IllegalStateException();
        return stack[count - 1];
    }


    public void print() {
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public String reverse(String s) {
        char[] charArray = s.toCharArray();
        Stack stack = new Stack();
        for (char ch : charArray) {
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean validateExpression(String expression){
        char [] charArray = expression.toCharArray();
        Stack stack = new Stack();
        for(char c: charArray){
            if(this.isOpeningBracket(c)){
                stack.push(c);
            }
            if(this.isClosingBracket(c)){
                if(stack.isEmpty()) return  false;
                char opning = (char)stack.pop();
                if(!isBracketsMatches(opning , c)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return  false;
        }

        return true;
    }
    private List<Character> OPENING_BRACKETS = Arrays.asList(new Character[]{'(', '{', '[', '<'});
    private List<Character> CLOSING_BRACKETS = Arrays.asList(new Character[]{')', '}', ']', '>'});
    private boolean isOpeningBracket(char ch){
        return OPENING_BRACKETS.contains(ch);
    }
    private boolean isClosingBracket(char c){
        return CLOSING_BRACKETS.contains(c);
    }
    private boolean isBracketsMatches(char left ,  char rigth){
        return (OPENING_BRACKETS.indexOf(left) == CLOSING_BRACKETS.indexOf(rigth));
    }


}
