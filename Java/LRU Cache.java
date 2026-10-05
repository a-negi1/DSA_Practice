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