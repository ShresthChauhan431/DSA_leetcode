class LFUCache {
    
    Map<Integer, Integer> map;
    Map<Integer, Integer> freq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        min = 1;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        int f = freq.get(key);
        freq.put(key, f + 1);

        freqToKeys.get(f).remove(key);
        
        if(freqToKeys.get(f).isEmpty() && min == f){
            min++;
        }
        freqToKeys.computeIfAbsent(f + 1, k -> new LinkedHashSet<>()).add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity == 0)return;
        if(map.containsKey(key)){
            map.put(key, value);
            get(key);
            return;
        }
        if(map.size() >= capacity){
            int x = freqToKeys.get(min).iterator().next();
            freqToKeys.get(min).remove(x);
            freq.remove(x);
            map.remove(x);
        }

        map.put(key, value);
        freq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */