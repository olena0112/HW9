package org.example;

public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyQueue() {
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
    public T poll(){
        if(first!=null){
            T result=first.data;
            first=first.next;
            return result;
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public int size() {
        return size;
    }
    public T peek(){
        if(first!=null)
            return first.data;
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public void clear(){
        first=last=null;
        size=0;
    }
}
