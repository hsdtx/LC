package com.company.review;

import java.util.HashMap;
import java.util.Set;

public class LRUCache {

    class LinkedNode{
        int key;
        int value;
        LinkedNode prev; //前一个节点
        LinkedNode next; //后一个节点

        public LinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; //LRU的总容量
    private HashMap<Integer, LinkedNode> cache;
    private LinkedNode head, tail; //双向链表的头尾节点

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity, 0.75f);
        this.head = new LinkedNode(-1, -1);
        this.tail = new LinkedNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int value){
        LinkedNode newNode;
        if (this.cache.containsKey(key)){
            newNode = this.cache.get(key);

            //先出链表中拿出来
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
            newNode.value = value;
        }else{
            newNode = new LinkedNode(key, value);
        }

        //再加到头节点后面
        LinkedNode temp = this.head.next;
        this.head.next = newNode;
        newNode.prev = this.head;
        newNode.next = temp;
        temp.prev = newNode;

        this.cache.put(key, newNode);
        if (this.cache.size() > this.capacity){
            this.removeLastRecentlyUsedOne();
        }
    }

    public int get(int key){
        LinkedNode getOne = this.cache.get(key);

        if (getOne == null){
            return -1;
        }

        //改变链表顺序
        LinkedNode prev = getOne.prev, next = getOne.next;
        prev.next = next;
        next.prev = prev;

        getOne.next = this.head.next;
        getOne.prev = this.head;
        this.head.next.prev = getOne;
        this.head.next = getOne;

        return getOne.value;
    }

    private void removeLastRecentlyUsedOne(){
        LinkedNode tailPrev = this.tail.prev;
        this.tail.prev = tailPrev.prev;
        this.tail.prev.next = this.tail;
        tailPrev.next = null;
        tailPrev.prev = null; //gc

        this.cache.remove(tailPrev.key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<Integer> keySet = this.cache.keySet();

        for (int key: keySet){
            sb.append(String.format("key = %s, value= %s, next.key = %s, prev.key = %s; ", key, this.cache.get(key).value, this.cache.get(key).next.key, this.cache.get(key).prev.key));
        }

        return sb.toString();
    }
    
}
