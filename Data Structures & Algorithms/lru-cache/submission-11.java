class Node{
    int val;
    int key;
    Node next;
    Node prev;
    Node(int val, int key){
        this.val = val;
        this.key = key;
    }
}
class LRUCache {

    int size;
    HashMap<Integer,Node> lru;
    Node head;
    Node tail;
    Node prev;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.lru = new HashMap<>(capacity);
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }
    public void insert(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    public void delete(Node node){
        Node temp = node.prev;
        Node next = node.next;
        next.prev = temp;
        temp.next = next;
    }
    public int get(int key) {
        if(lru.containsKey(key)){
            Node node = lru.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(lru.containsKey(key)){
            delete(lru.get(key));
        }
        Node node = new Node(value, key);
        lru.put(key, node);
        insert(node);
        if(lru.size() > size){
            Node temp = this.tail.prev;
            delete(temp);
            lru.remove(temp.key);
        }
    }
}
