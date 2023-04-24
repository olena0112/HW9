package org.example;

import java.util.Objects;

public class MyLinkedList <T> {
    private Node<T> first;
    private Node<T> last;

    private int size;

    public MyLinkedList() {
        first = null;
    }

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (first == null) {
            first = this.last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }


    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).data;
    }

    public int size() {
        return size;
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedData;
        if (index == 0) {
            removedData = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedData = prev.next.data;
            prev.next = prev.next.next;
            if(index==size-1){
                last=prev;
            }
        }

        size--;
        return removedData;
    }
    public void clear(){
        first=last=null;
        size=0;
    }
}



