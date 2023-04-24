package org.example;

import java.util.Arrays;

public class MyStack<T> {
    private int top=-1;
    private Object[] values=new Object[10];
    private int size =0;
    public boolean isEmpty(){
        return (top==-1);
    }
    public void push(T toAdd){
        rebalanceIfNeed();
        values[size]=toAdd;
        size++;
    }

    public void remove(int index){
        values[index]=null;
    }
    private void rebalanceIfNeed(){
        if(values.length-1==size) values= Arrays.copyOf(values,values.length+10);
    }
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        else return (T)values[top--];
    }
    public T peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        else return (T)values[top];
    }
    public int size(){
        return size;
    }
    public void clear(){
        final Object[] es = values;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }
    @Override
    public String toString(){
        StringBuilder st=new StringBuilder();
        for(int i=0;i<size;i++){
            st.append(values[i]).append("\n");
        }
        return st.toString();
    }
}
