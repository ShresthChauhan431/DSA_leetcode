class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        long total = (long) n * (n - 1) / 2;
        long x = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int[] i : intervals){
            int st = i[0];
            int end = i[1];
            
            int l = 0, r = list.size();
            while(l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid) < st) l = mid + 1;
                else r = mid;
            }
            x += l;
            
            l = 0;
            r = list.size();
            while(l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid) <= end) l = mid + 1;
                else r = mid;
            }
            list.add(l, end);
        }
        
        return total - x;
    }
}