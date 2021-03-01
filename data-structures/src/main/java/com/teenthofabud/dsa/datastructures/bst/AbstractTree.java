package com.teenthofabud.dsa.datastructures.bst;

import lombok.Getter;

import java.util.Comparator;

@Getter
public abstract class AbstractTree<T> implements TreeOperations <T>{

    public abstract int sumOfTree();

    public abstract int height();

    public abstract int count();

    protected Node<T> createNode(T data) {
        Node<T> ndptr = new Node<T>(data);
        return ndptr;
    }

    private Comparator<T> cmp;

    public AbstractTree(Comparator<T> cmp) {
        this.cmp = cmp;
    }


}
