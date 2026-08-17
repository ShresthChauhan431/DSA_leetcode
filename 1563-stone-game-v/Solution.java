class Solution {
    int[][] dp;
    public int helper(int i, int j, int[] stones){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int total = 0;
        for(int k = i; k <= j; k++){
            total += stones[k];
        }
        int max = 0;
        int left = 0;
        for(int mid = i; mid <= j; mid++){
            left += stones[mid];
            int right = total - left;
            if(left < right){
                max = Math.max(max, left + helper(i, mid, stones));
            }else if(left > right){
                max = Math.max(max, right + helper(mid + 1, j, stones));
            }else{
                max = Math.max(max, Math.max(left + helper(i, mid, stones), right + helper(mid + 1, j, stones)));
            }
        }
        return dp[i][j] = max;
    }
    public int stoneGameV(int[] stoneValue) {
        dp = new int[stoneValue.length + 1][stoneValue.length + 1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(0, stoneValue.length - 1, stoneValue);
    }
}