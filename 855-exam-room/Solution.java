class ExamRoom {
    TreeSet<Integer> set ;
    int n;
    public ExamRoom(int n) {
        this.n = n;
        set = new TreeSet<>();
    }
    
    public int seat() {
        if(set.size() == 0) {
            set.add(0);
            return 0;
        }
        
        
        int prev = -1; 
        int best = 0; 
        int max = set.getFirst();
        
        for(int i: set){
            if(prev != -1){
                int dist = (i - prev)/2;
                
                if(dist > max){
                    best = prev + dist;
                    max = dist; 
                }
            }
            prev = i;
        }
        
        
        if(n - 1 - set.getLast() > max)
            best = n - 1;
        
        set.add(best);
        return best;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */