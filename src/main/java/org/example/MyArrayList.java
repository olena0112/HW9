package org.example;

import java.util.Arrays;

public class MyArrayList <T>{
    private Object[] values=new Object[10];
    private int size =0;
    public void add(T toAdd){
        rebalanceIfNeed();
        values[size]=toAdd;
        size++;
    }
    public void remove(int index){
        values[index]=null;
    }
    private void rebalanceIfNeed(){
        if(values.length-1==size) values=Arrays.copyOf(values,values.length+10);
    }
    public T get(int index){
        return (T) values[index-1];
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
