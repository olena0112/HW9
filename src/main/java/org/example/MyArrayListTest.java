package org.example;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println("Розмір колекції: " + list.size());
        System.out.println("Елемент за індексом 1: " + list.get(1));
        list.remove(0);
        System.out.println("Розмір колекції після видалення: " + list.size());
        list.toString();
        list.clear();
        System.out.println("Розмір колекції після очищення: " + list.size());

        MyLinkedList<String> linked = new MyLinkedList<>();
        linked .add("Apple");
        linked .add("Banana");
        linked .add("Orange");
        System.out.println("Розмір колекції: " + linked .size());
        System.out.println("Елемент за індексом 1: " + linked .get(1));
        linked.remove(0);
        System.out.println("Розмір колекції після видалення: " + linked.size());
        linked.clear();
        System.out.println("Розмір колекції після очищення: " + linked.size());

        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);
        System.out.println(map.get("apple"));
        System.out.println(map.get("banana"));
        System.out.println(map.get("cherry"));
        map.remove("banana");
        System.out.println(map.size());
        map.clear();
        System.out.println(map.size());
    }
}
