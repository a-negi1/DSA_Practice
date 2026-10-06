// using built in DataStruture LinkedHashMap(ordered hashmap)

class LRUCache {
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map= new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer>eldest){
                return size()>capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
       map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Implementation from scratch

class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap <Integer,Node> map= new HashMap<>();
    Node head,tail;
    int capacity;
    
    void add(Node node){
       node.next = head.next;
       node.prev = head;
       head.next.prev = node;
       head.next = node;

    }
    void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

         head=new Node(0,0);
         tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
           return -1;
        }
         Node n = map.get(key);
        delete(n);
        add(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
            node.val = value;
            add(node);
            return;
        }
        else{
            Node node = new Node(key,value);
            map.put(key,node);
            add(node);
            if(map.size() >  capacity){
                Node lru = tail.prev;
                map.remove(lru.key);
                delete(lru);

            }

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */