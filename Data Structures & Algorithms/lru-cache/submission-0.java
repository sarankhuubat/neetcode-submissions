class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        private Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    Map<Integer, Node> store;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        store = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(store.containsKey(key)){
            Node node = store.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(store.containsKey(key)){
            remove(store.get(key));
        }

        Node node = new Node(key, value);
        store.put(key, node);
        insert(node);

        if(store.size() > capacity){
            Node tmp = this.left.next;
            remove(tmp);
            store.remove(tmp.key);
        }
    }

    private void remove(Node head){
        Node prev = head.prev;
        Node next = head.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        this.right.prev = node;
        node.prev = prev;
    }
}
