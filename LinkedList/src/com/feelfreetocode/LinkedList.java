
package com.feelfreetocode;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last ;
    private  int size ;

    private class Node{
        private Integer value;
        private Node next ;
        Node(Integer value , Node next){
            this.value = value ;
            this.next = next;
        }
        Node(Integer value ){
            this.value = value;
        }
        @Override
        public String toString() {
            return value.toString();
        }
    }


    public void addFirst(Integer value){
        Node node  = new Node(value);
        if(first == null){
            first = last  = node;
        }else{
            node.next = first ;
            first = node;
        }

        size++;

    }

    public Node getLast(){
        return last;
    }
    public Node getFirst(){
        return first;
    }

    public void addLast(Integer  value){
        if(first == null){
            addFirst(value);
            return ;
        }
        last.next = new Node(value);
        last  = last.next;
        size++;
    }

    public Integer indexOf(Integer value){
        if(first == null){
            return -1 ;
        }
        int index = 0;
        Node tempNode = first ;
        while(tempNode != null){
            if(tempNode.value == value){
                return index ;
            }
            tempNode = tempNode.next;
            index++;
        }
        return -1;
    }

    public boolean contains(Integer value){
        if(this.indexOf(value) >= 0){
            return true;
        }
        return false;
    }


    public void removeFirst() throws Exception{
        if(first == null){
            throw new NoSuchElementException();
        }
        if(first == last)
            first = last =  null;
        else{
            Node second = first.next;
            first.next = null;
            first = second ;
        }

        size--;

    }

    public Node removeLast() throws  Exception {
        Node removedNode = last ;
        if(first == null){
            return null;
        }
        if(first.next == null){
            this.removeFirst();
        }else{
            Node tempNode = first ;
            while(tempNode.next.next != null ){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            last = tempNode;
        }
        size--;
        return removedNode ;
    }
    public void print(){
        Node tempNode = first;
        while(tempNode!=null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }
    public int size(){
        return size;
    }

    public Integer[] toArray(){
        Node current = first ;
        Integer[] array = new Integer[size()];
        int index = 0 ;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        if(this.size == 0 ){
            return ;
        }
//        [12->13->14->15->16]
//          p  c   n
//                      p   c   n
//        [12<-13<-14<-15<-16];
        Node previous = first ;
        Node current = first.next;
        while(current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        Node l = last ;
        last  = first ;
        first  = l ;
        last.next = null;
    }

    public int getValueAtKthIndexFromEnd(int position){
//        if position = 3
//        [12->13->14->15->16]
//                 n1      n2
        if(size == 0 ){
            throw  new IllegalStateException();
        }
        if(position == 1){
            return first.value;
        }
        Node a = first ;
        Node b = first ;
        for(int i = 1 ; i < position; i++){
            b = b.next;
            if(b.next==null){
              throw new   IllegalArgumentException();
            }
        }

        while(b.next != null ){
            b = b.next;
            a = a.next;
        }
        return a.value;
    }
}
