package com.teenthofabud.dsa.datastructures.bst;

import java.util.Comparator;

public class BSTDriver {

    public static void main(String[] args) {
        //int[] arr = {5,2,1,3,8,9,6};
        //int[] arr = {5,2,1,3,9};
        //int[] arr = {50,30,20,40,70,60,80};
        int[] arr = {5,2,1,3,9,10};
        //int[] arr = {1,2,3,4,5};
        int item = 20;
        Comparator<Integer> cmp = (x, y) -> {
            return Integer.compare(x, y);
        };
        AbstractTree<Integer> bst = new BinarySearchTree<Integer>(cmp);
        System.out.println("Insertion Order: -------------------------------------------------------------");
        for(int n : arr) {
            bst.insert(n);
            System.out.println(n);
        }
        System.out.println("\nLevel Order: -------------------------------------------------------------");
        bst.levelOrder();
        System.out.println("\nIn Order: -------------------------------------------------------------");
        bst.inOrder();
        System.out.println("\nPre Order: -------------------------------------------------------------");
        bst.preOrder();
        System.out.println("\nPost Order: -------------------------------------------------------------");
        bst.postOrder();
        System.out.println("\nHeight: -------------------------------------------------------------");
        System.out.println(bst.height());
        System.out.println("\nDeleting item: " + item + " -------------------------------------------------------------");
        boolean status = bst.delete(item);
        System.out.println(status);
        System.out.println("\nLevel Order: -------------------------------------------------------------");
        bst.levelOrder();
        System.out.println("\nIn Order: -------------------------------------------------------------");
        bst.inOrder();
        System.out.println("\nPre Order: -------------------------------------------------------------");
        bst.preOrder();
        System.out.println("\nPost Order: -------------------------------------------------------------");
        bst.postOrder();
        System.out.println("\nHeight: -------------------------------------------------------------");
        System.out.println(bst.height());
    }

}
