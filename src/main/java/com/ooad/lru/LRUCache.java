package com.ooad.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //Sentinel head and tail nodes to avoid edge case handling
    private LinkedNode head, tail;
    private int size;
    private int capacity;
    private Map<Integer, LinkedNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        map = new HashMap<>();
        //make head and tail linked
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node= map.get(key);
        if(node == null)
            return -1;
        //Since this key has been accessed, it needs to be moved to head
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if(node == null) {
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;
            // Add the recently added node to head as this is access recently
            addNode(newNode);
            map.put(key, newNode);
            size++;
            //size is beyond capacity, hence we need to remove eldest
            if(size > capacity) {
                LinkedNode eldest = removeEldestEntry();
                map.remove(eldest.key, eldest);
                --size;
            }
        } else {
            node.value = value;
            //since the key has been accessed(updated), hence moving to head
            moveToHead(node);
        }
    }
    //idea is to use hash map for get and put as O(1) time
    //also use double linked list as the addition and removal
    // is of constant time. We can try using single linked list
    private class LinkedNode {
        int key;
        int value;
        LinkedNode next;
        LinkedNode prev;
    }

    /**
     * Add Node to the head
     */
    private void addNode(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        LinkedNode prev = node.prev;
        LinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private LinkedNode removeEldestEntry() {
        LinkedNode eldest = tail.prev;
        removeNode(eldest);
        return eldest;
    }

    void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }
}
