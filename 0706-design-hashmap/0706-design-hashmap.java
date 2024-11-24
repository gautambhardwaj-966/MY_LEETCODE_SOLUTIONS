class MyHashMap {

    private static final int SIZE = 10000;
    
    private final Bucket[] map;

    public MyHashMap() {
        map = new Bucket[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new Bucket();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        map[index].put(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        return map[index].get(key);
    }

    public void remove(int key) {
        int index = hash(key);
        map[index].remove(key);
    }

    private static class Bucket {
        private ListNode head;

        public Bucket() {
            head = null;
        }

        public void put(int key, int value) {
            ListNode node = head;
            while (node != null) {
                if (node.key == key) {
                    node.value = value; 
                    return;
                }
                node = node.next;
            }
            head = new ListNode(key, value, head); 
        }

        public int get(int key) {
            ListNode node = head;
            while (node != null) {
                if (node.key == key) {
                    return node.value; 
                }
                node = node.next;
            }
            return -1; 
        }

        public void remove(int key) {
            if (head == null) return;
            
            if (head.key == key) {
                head = head.next;
                return;
            }
            
            ListNode node = head;
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }
    }

    private static class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */