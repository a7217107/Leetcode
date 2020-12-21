import java.util.HashMap;

public class Leetcode146 {


    public static void main(String[] args) {
        Leetcode146 cache = new Leetcode146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(3));
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    private HashMap<Integer, ListNode> map;
    private int size;
    private int capacity;
    private ListNode head;
    private ListNode tail;

    private class ListNode {
        private Integer key;
        private ListNode pre;
        private ListNode next;
        private Integer val;

        public ListNode() {
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Leetcode146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) return -1;
        moveHead(node);
        return node.val;
    }

    private void del(ListNode n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    private void moveHead(ListNode n) {
        del(n);
        toHead(n);
    }

    private void toHead(ListNode n) {
        n.next = head.next;
        head.next = n;
        n.pre = head;
        n.next.pre = n;
    }

    public void put(int key, int value) {
        ListNode n = map.get(key);
        if (n == null) {
            n = new ListNode(key, value);
            map.put(key, n);
            toHead(n);
            size++;
            if (size > capacity) {
                ListNode pre = tail.pre;
                del(pre);
                map.remove(pre.key);
                --size;
            }
        } else {
            n.val = value;
            moveHead(n);
        }
    }
}
