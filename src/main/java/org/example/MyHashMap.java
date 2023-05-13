package org.example;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


import java.util.Objects;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);
        if (buckets[index] == null) {
            buckets[index] = newNode;
            size++;
        } else {
            Node<K, V> current = buckets[index];
            while (current != null) {
                if (Objects.equals(current.getKey(), key)) {
                    current.setValue(value);
                    return;
                }
                current = current.getNext();
            }
            newNode.setNext(buckets[index]);
            buckets[index] = newNode;
            size++;
        }
        resizeIfNeeded();
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;
        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                if (prev == null) {
                    buckets[index] = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                size--;
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;
        return index >= 0 ? index : index + buckets.length;
    }

    private void resizeIfNeeded() {
        if (size >= LOAD_FACTOR * buckets.length) {
            int newCapacity = buckets.length * 2;
            Node<K, V>[] newBuckets = new Node[newCapacity];
            for (Node<K, V> node : buckets) {
                while (node != null) {
                    int index = getIndex(node.getKey(), newCapacity);
                    Node<K, V> next = node.getNext();
                    node.setNext(newBuckets[index]);
                    newBuckets[index] = node;
                    node = next;
                }
            }
            buckets = newBuckets;
        }
    }

    private int getIndex(K key, int capacity) {
        if (key == null) {
            return 0;
        }
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

}