class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        private Node(int k, int v){
            key = k;
            value = v;
        }
    }

    private Map<Integer, Node> store;
    int capacity;
    private Node left;
    private Node right;

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

    private void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        node.prev = prev;
        this.right.prev = node;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
