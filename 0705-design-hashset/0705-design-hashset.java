class MyHashSet {

    private final int size = 1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int hashIndex = hash(key);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int hashIndex = hash(key);
        LinkedList<Integer> bucket = buckets[hashIndex];
        bucket.remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int hashIndex = hash(key);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */