class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0; 
        long count =0; 
        long[] arr = {1000L,
                     1000000L,
                     1000000000L,
                     1000000000000L,
                     1000000000000000L};
        for(int i=0; i<arr.length; i++){
            long x = arr[i];
            long y = (i+1<arr.length)?arr[i+1]-1:Long.MAX_VALUE;
            int comma = i+1;
            if(n<x) break;
            long a = Math.min(n,y);
            count += (long) comma*(a-x+1);
        }
        return count; 
    }
}