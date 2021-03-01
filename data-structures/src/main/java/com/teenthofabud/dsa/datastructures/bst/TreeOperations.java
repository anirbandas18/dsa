package com.teenthofabud.dsa.datastructures.bst;

public interface TreeOperations<T> {

    public void insert(T item);

    public boolean delete(T item);

    public void levelOrder();

    public void inOrder();

    public void preOrder();

    public void postOrder();

    public boolean isPresent(T item);
}
