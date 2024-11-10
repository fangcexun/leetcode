package hot100.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LC146 {
    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {

        Node head = new Node();
        Node tail = new Node();

        int capacity;
        Map<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            int value = -1;

            if (map.containsKey(key)) {
                value = map.get(key).value;
                removeNode(key);
                putNodeAfterHead(key, value);
                return value;
            }

            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                removeNode(key);
                putNodeAfterHead(key, value);
                return;
            }

            if (map.size() < capacity) {
                putNodeAfterHead(key, value);
            } else {
                Node lastNode = tail.prev;
                removeNode(lastNode.key);
                putNodeAfterHead(key, value);
            }
        }
        private void removeNode(int key) {
            Node removeNode = map.get(key);
            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;

            removeNode.next = null;
            removeNode.prev = null;

            map.remove(key);
        }

        private void putNodeAfterHead(int key, int value) {

            // 放入 head 后面
            Node node = new Node(key, value);
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;

            map.put(key, node);
        }
    }

}
