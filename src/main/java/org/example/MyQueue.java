package org.example;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getValue();
    }

    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = head.getValue();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

