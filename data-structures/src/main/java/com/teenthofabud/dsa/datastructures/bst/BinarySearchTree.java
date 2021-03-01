package com.teenthofabud.dsa.datastructures.bst;

import java.util.*;

public class BinarySearchTree<T> extends AbstractTree<T> {

    private Node<T> root;
    private int count;

    public BinarySearchTree(Comparator<T> cmp) {
        super(cmp);
        this.count = 0;
    }

    public int sumOfTree() {
        return 0;
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node<T> ptr) {
        if(ptr == null) {
            return 0;
        } else {
            int leftDepth = height(ptr.getLeft());
            int rightDepth = height(ptr.getRight());
            return Math.max(leftDepth, rightDepth) + 1; // 1 is explicitly added for considering height of root only node in tree
        }
    }

    public int count() {
        return this.count;
    }

    public void insert(T item) {
        Node<T> ndptr = super.createNode(item);
        if(root == null) {
            root = ndptr;
            count++;
        } else {
            Node<T> ptr = null;
            Integer c = null;
            Queue<Node<T>> q = new ArrayDeque<Node<T>>();
            q.add(root);
            while(!q.isEmpty()) {
                ptr = q.poll();
                if(ptr != null ) {
                    c = compareNodes(ndptr, ptr);
                    if(ptr.getLeft() != null && c < 0) {
                        q.add(ptr.getLeft());
                    } else if(ptr.getRight() != null && c >= 0) {
                        q.add(ptr.getRight());
                    }
                }
            }
            if(ptr != null && c != null) {
                if(c < 0) {
                    ptr.setLeft(ndptr);
                } else {
                    ptr.setRight(ndptr);
                }
                count++;
            }
        }
    }

    private int compareNodes(Node<T> ndptr, Node<T> ptr) {
        return super.getCmp().compare(ndptr.getData(), ptr.getData());
    }

    public boolean delete(T key) {
        if(isPresent(key)) {
            Node<T> item = super.createNode(key);
            Node<T> bck = super.createNode(key);
            item = this.delete(root, item);
            boolean status = item != null;//&& this.compareNodes(item, bck) == 0;
            return status;
        } else {
            return false;
        }
    }

    private Node<T> delete(Node<T> ptr, Node<T> item) {
        if(ptr == null) {
            ptr = null;
        } else {
            int c = compareNodes(ptr, item);
            if(c < 0) { // right subtree
                ptr.setRight(delete(ptr.getRight(), item));
            } else if (c > 0) { // left subtree
                ptr.setLeft(delete(ptr.getLeft(), item));
            } else { // node found
                if(isLeaf(ptr)) { // leaf node
                    return null;
                } else if(onlyLeft(ptr)) { // node with left child only
                    return ptr.getLeft();
                } else if(onlyRight(ptr)) { // node with right child only
                    return ptr.getRight();
                } else { // node with both children
                    Node<T> minValueFromRightSubtree = this.minFromThisSubtree(ptr.getRight()); // get the least value from the right subtree of this node
                    ptr.setData(minValueFromRightSubtree.getData()); // replace the identified node's value with the least value present in the right subtree of this node
                    ptr.setRight(delete(ptr.getRight(), minValueFromRightSubtree)); // delete the node with the least value from the right subtree of this node
                }
            }
        }
        return ptr; // return node with updated subtree references
    }

    private Node<T> minFromThisSubtree(Node<T> ptr) {
        Node<T> ndptr = ptr;
        Node<T> min = ptr;
        while(ndptr.getLeft() != null) {
            if(this.compareNodes(ndptr, ptr) > 0) {
                min = ndptr;
            }
            ndptr = ndptr.getLeft();
        }
        return min;
    }

    public void levelOrder() {
        Node<T> ptr = null;
        Queue<Node<T>> q = new ArrayDeque<Node<T>>();
        q.add(root);
        while(!q.isEmpty()) {
            ptr = q.poll();
            if(ptr != null ) {
                System.out.print(ptr + " ");
                if(ptr.getLeft() != null) {
                    q.add(ptr.getLeft());
                }
                if(ptr.getRight() != null) {
                    q.add(ptr.getRight());
                }
            }
        }
    }

    /*public void inOrder() {
        Stack<Node<T>> s = new Stack<>();
        Node<T> ptr = root;
        while(ptr != null || !s.empty()) {
            while(ptr != null) {
                s.push(ptr);
                ptr = ptr.getLeft();
            }
            ptr = s.pop();
            System.out.println(ptr + " ");
            ptr = ptr.getRight();
        }
    }*/

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node<T> ptr) {
        if(ptr == null) {
            return;
        } else {
            inOrder(ptr.getLeft());
            System.out.print(ptr + " ");
            inOrder(ptr.getRight());
        }
    }

    /*public void preOrder() {
        Stack<Node<T>> s = new Stack<>();
        Node<T> ptr = root;
        s.push(ptr);
        while(!s.empty()) {
            ptr = s.pop();
            System.out.println(ptr + " ");
            if(ptr.getLeft() != null) {
                s.push(ptr.getLeft());
            }
            if(ptr.getRight() != null) {
                s.push(ptr.getRight());
            }
        }*/

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node<T> ptr) {
        if(ptr == null) {
            return;
        } else {
            System.out.print(ptr + " ");
            inOrder(ptr.getLeft());
            inOrder(ptr.getRight());
        }
    }

    private boolean isLeaf(Node<T> ptr) {
        return ptr != null && ptr.getLeft() == null && ptr.getRight() == null;
    }

    private boolean onlyLeft(Node<T> ptr) {
        return ptr != null && ptr.getLeft() != null && ptr.getRight() == null;
    }

    private boolean onlyRight(Node<T> ptr) {
        return ptr != null && ptr.getLeft() == null && ptr.getRight() != null;
    }

    public void postOrder() {
        postOrder(this.root);
    }

    public boolean isPresent(T item) {
        Node<T> key = this.createNode(item);
        Stack<Node<T>> s = new Stack<>();
        s.push(this.root);
        boolean flag = false;
        while(!s.empty()) {
            Node<T> ptr = s.pop();
            if(this.compareNodes(ptr, key) == 0) {
                flag = true;
                break;
            } else {
                if(ptr.getLeft() != null) {
                    s.push(ptr.getLeft());
                }
                if(ptr.getRight() != null) {
                    s.push(ptr.getRight());
                }
            }
        }
        return flag;
    }

    private void postOrder(Node<T> ptr) {
        if(ptr == null) {
            return;
        } else {
            postOrder(ptr.getLeft());
            postOrder(ptr.getRight());
            System.out.print(ptr + " ");
        }
    }
}
