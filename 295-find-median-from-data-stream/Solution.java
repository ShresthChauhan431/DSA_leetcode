class MedianFinder {
    PriorityQueue<Integer> pq;
    public MedianFinder() {
        pq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq.offer(num);
    }
    
    public double findMedian() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(pq);
        int n = list.size();
        if(n % 2 == 0 && n >= 2)
        return (double)(list.get(n/2) + list.get(n/2 - 1))/2;
        else return list.get(n/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */