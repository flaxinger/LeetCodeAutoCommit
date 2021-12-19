class LRUCache {


    Map<Integer, Integer> map;
    int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        int result = map.getOrDefault(key, -1);
        if(result!=-1){
            map.remove(key);
            map.put(key, result);
        }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,  value);
            return;
        }
        if(map.size() == cap)
            map.remove(map.keySet().toArray()[0]);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */