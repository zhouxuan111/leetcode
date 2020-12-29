package com.zx.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法实现
 * @author xuanzhou
 * @date 2020/12/29 6:02 下午
 */
public class LRUCache {

    Map<Integer, Node> map;

    int capacity;

    Node head;

    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (null == node) {
            return -1;
        }
        refreshNode(node);
        return node.value;
    }

    public void refreshNode(Node node) {
        if (node == tail) {
            return;
        }
        removeNode(node);
        addNodeToTail(node);
    }

    public void removeNode(Node node) {
        if (node == tail) {
            tail = tail.pre;
        }
        else if (node == head) {
            head = head.next;
        }
        else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    public void addNodeToTail(Node node) {
        if (null != tail) {
            tail.next = node;
            node.next = null;

            node.pre = tail;
        }
        tail = node;
        if (null == head) {
            head = node;
        }

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (null == node) {
            if (map.size() >= capacity) {
                //删除链表头元素 - 注意先删除集合中数据
                map.remove(head.key);
                removeNode(head);

            }
            node = new Node(key, value);
            addNodeToTail(node);
            map.put(key, node);
        }
        else {
            node.value = value;
            refreshNode(node);
        }
    }

    //双向链表节点类
    class Node {

        int key;

        int value;

        Node pre;

        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}

    }
}
