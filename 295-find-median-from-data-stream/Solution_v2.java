class MedianFinder {
    PriorityQueue<Integer> pq2;
    PriorityQueue<Integer> pq1;

    public MedianFinder() {
        pq2 = new PriorityQueue<>();
        pq1 = new PriorityQueue<>((a,b) -> (b - a));
    }
    
    public void addNum(int num) {
        pq2.offer(num);
        if(!pq1.isEmpty() && !pq2.isEmpty() & pq1.peek() > pq2.peek()){
            int x = pq1.poll();
            int y = pq2.poll();
            pq1.offer(y);
            pq2.offer(x);
        }
        if(pq1.size() < pq2.size()){
            int x = pq2.poll();
            pq1.offer(x);
        }
    }
    
    public double findMedian() {
        if(pq1.size() == pq2.size()){
            double x = pq2.peek();
            double y  = pq1.peek();
            return (x + y) / 2;
        }else{
            // if()
            return pq1.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */