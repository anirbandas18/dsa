package com.teenthofabud.dsa.datastructures.bst;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Node<T> {

    @ToString.Include
    private T data;
    @ToString.Exclude
    private Node<T> left;
    @ToString.Exclude
    private Node<T> right;

    public Node(T data) {
        this.data = data;
    }

}
