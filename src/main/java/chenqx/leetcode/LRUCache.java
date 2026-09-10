package chenqx.leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.lang.String;

class LRUCache {
    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int capacity;
    private int size;
    private DLinkNode head,tail;

    class DLinkNode {
        int key,value;
        DLinkNode pre,next;
        public DLinkNode(){};
        public DLinkNode(int _key,int _value){
            key=_key;
            value=_value;
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode==null){
            return -1;
        }
        moveToHead(dLinkNode);
        return dLinkNode.value;

    }

    public void put(int key, int value) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode==null){
            dLinkNode = new DLinkNode(key, value);
            cache.put(key, dLinkNode);
            addHead(dLinkNode);

            size++;
            if(size>capacity){
                DLinkNode oldNode = removeTail();
                cache.remove(oldNode.key);
                size--;
            }
        }else{
            dLinkNode.value = value;
            moveToHead(dLinkNode);
        }

    }

    DLinkNode removeTail(){
        DLinkNode oldTail= tail.pre;
        remove(oldTail);
        return oldTail;
    }
    void addHead(DLinkNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    void remove(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }
    void moveToHead(DLinkNode node){
        remove(node);
        addHead(node);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}

