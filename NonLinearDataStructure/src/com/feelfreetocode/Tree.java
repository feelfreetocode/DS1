package com.feelfreetocode;

public class Tree {
    private Node root;
    private class Node{
        private Node leftChild ;
        private Comparable value;
        private  Node rightChild;

        Node(Comparable value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value : "+ value;
        }
    }

    public void swapNode(){
        Node temp = root.leftChild ;
        root.leftChild = root.rightChild ;
        root.rightChild = temp;
    }

    public void add(Comparable value){
        Node node = new Node(value);
        if(root == null){
            root = node;
            return ;
        }

        Node current = root;
        while(true){
            int compareResult = value.compareTo(current.value) ;
            if(compareResult == 0)
                return ;
            if(compareResult > 0){
                if(current.rightChild != null)
                    current = current.rightChild;
                else{
                    current.rightChild = node;
                    break;
                }
            }else{
                if(current.leftChild != null)
                    current = current.leftChild;
                else{
                    current.leftChild = node;
                    break;
                }
            }
        }
    }

    public Object find(Comparable value){
        Node current = root;
        while(current != null){
            if(current.value.compareTo(value)== 0){
                return true;
            }
            else if(value.compareTo(current.value)>0){
                current = current.rightChild;
            }else{
                current = current.leftChild;
            }
        }
        return false;
    }

    public void inOrder(){
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    public void postOrder(){
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    public void preOrder(){
        System.out.println();
        preOrder(root);
        System.out.println();
    }

    private void postOrder(Node root){
        if(root == null) return;

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    private void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.value + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);

    }

    private void inOrder(Node root){
        if(root ==  null) return;
        inOrder(root.leftChild);
        System.out.print(root.value + " ");
        inOrder(root.rightChild);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null) return -1;
        if(root.leftChild == null && root.rightChild== null ) return 0;
        return 1 + max(height(root.leftChild) , height(root.rightChild));
    }

    private int max(int a , int b){
        return (a > b) ? a : b;
    }

    public Object min(){
        return min(root , 12);
    }

    private Node min(Node root , int i){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.leftChild != null){
            current = current.leftChild;
        }
        return current;
    }


    private Node min(Node root) {
        if(isLeaf(root)){
            return root;
        }
        Node leftMin = min(root.leftChild);
        Node rightMin = min(root.rightChild);
        return min(min(leftMin , rightMin) , root);
    }

    private Node min(Node a , Node b){
        return (a.value.compareTo(b.value)> 0) ? b : a;
    }




    private boolean hasRightChild(Node root){
        return (root.rightChild != null);
    }

    private boolean hasLeftChild(Node root){
        return (root.leftChild != null);
    }

    private boolean isLeaf(Node root){
        return ( root.leftChild == null && root.rightChild == null);
    }


    public boolean compare(Tree b ){
        if(b == null)return  false;
        return compare(this.root  , b.root);
    }

    private boolean compare(Node root, Node rootb) {
        if (root == null && rootb == null)
            return true;

        if (root != null && rootb != null) {
            if (root.value.compareTo(rootb.value) == 0
                    && compare(root.leftChild, rootb.leftChild)
                    && compare(root.rightChild, rootb.rightChild)) {
                return true;

            } else {
                return false;
            }
        }
        return false;
    }


    public boolean isValidBinarySearchTree(){
        return validateBinarySearchTree(root , null , null );
    }

    private boolean validateBinarySearchTree(Node root , Comparable lowerLimit , Comparable upperLimit){
        if(root == null){
            return true;
        }

        if(lowerLimit != null && upperLimit!=null) {
            return (root.value.compareTo(lowerLimit) > 0 && root.value.compareTo(upperLimit) < 0);

        }if(lowerLimit != null && upperLimit==null) {
            return (root.value.compareTo(lowerLimit) > 0);
        }if(lowerLimit == null && upperLimit!=null) {
            return (root.value.compareTo(upperLimit) < 0);
        }

        return
                validateBinarySearchTree(root.leftChild , lowerLimit , root.value)
                && validateBinarySearchTree(root.rightChild , root.value , upperLimit);

    }


}
