package linkedlist;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, DoublyListNode> linkedMap;
    int capacity;
    int currSize = 0;
    DoublyListNode dummyStart = new DoublyListNode(-1, -1);
    DoublyListNode dummyEnd = new DoublyListNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyStart.next = dummyEnd;
        dummyEnd.prev = dummyStart;
        linkedMap = new HashMap<Integer, DoublyListNode>();
    }

    public int get(int key) {
        DoublyListNode node = linkedMap.getOrDefault(key, null);
        if(node == null) {
            return -1;
        } else {
            updateNodeToMRU(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        DoublyListNode exist = linkedMap.getOrDefault(key, null);
        if(exist == null) {
            DoublyListNode newNode = new DoublyListNode(value, key);
            if(currSize == capacity) {
                DoublyListNode lru = dummyStart.next;
                dummyStart.next = lru.next;
                dummyStart.next.prev = dummyStart;
                linkedMap.put(lru.key, null);
                currSize--;
            }
            newNode.next = dummyEnd;
            newNode.prev = dummyEnd.prev;
            dummyEnd.prev.next = newNode;
            dummyEnd.prev = newNode;
            linkedMap.put(key, newNode);
            currSize++;
        } else {
            exist.val = value;
            updateNodeToMRU(exist);
        }
    }

    private void updateNodeToMRU(DoublyListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = dummyEnd;
        node.prev = dummyEnd.prev;
        dummyEnd.prev.next = node;
        dummyEnd.prev = node;
    }

    public class DoublyListNode {
        public int val;
        public DoublyListNode next;
        public DoublyListNode prev;
        public int key;

        public DoublyListNode(int x, int key) {
            val = x;
            this.key = key;
            next = null;
            prev = null;
        }
    }
}
