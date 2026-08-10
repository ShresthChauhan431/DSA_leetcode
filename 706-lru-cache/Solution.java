class LRUCache {
    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))  return -1;
        else {
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.add(key);
            map.put(key, value);
        }else{
            if(list.size() == cap){
                map.remove(list.getFirst());
                list.removeFirst();

            }
            list.add(key);
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */