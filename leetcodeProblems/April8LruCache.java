class Node{
    Node prev, next;
    int key, value;
    Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    int n;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        n = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        // connect head <-> tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        // else
        Node node = map.get(key);
        remove(node);// remove from that DLL
        insert(node);// insert at from of the LL
        return node.value;
    }
    private void remove(Node node){
        // any middle node
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    private void insert(Node node){
        // insertion at head
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            map.remove(node.key);
        }
        if(map.size() == n){
            Node lruNode = tail.prev;
            remove(lruNode);
            map.remove(lruNode.key);
        }
        Node node = new Node(key,value);
        insert(node);//insert at beginning
        map.put(key,node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
