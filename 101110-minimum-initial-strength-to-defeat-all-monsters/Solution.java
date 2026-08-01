class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length; 
        long[] arr = new long[n + 1];
        for(int[] b: boosts){
            int l = b[0], r = b[1];
            long v = b[2];
            arr[l] += v; 
            arr[r + 1] -= v;
        }

        long[] bonus = new long[n];
        long curr = 0;
        for(int i = 0; i < n; i++){
            curr += arr[i];
            bonus[i] = curr;
        }

        long[] req = new long[n];
        for(int i = 0; i < n; i++){
            req[i] = Math.max(0L, (long)monsters[i] - bonus[i]);
        }

        long min = req[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(min == 0){
                min = req[i];
            } else{
                min = Math.max(req[i], min + monsters[i]);
            }
        }
        return min;
    }
}