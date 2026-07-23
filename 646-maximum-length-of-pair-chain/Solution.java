class Solution {
    int[][] dp;
    public int helper(int i, int j, int[][] pairs){
        if(i == pairs.length){
            return 0;
        }
        if(dp[i][j + 1] != -1) return dp[i][j + 1];
        int notake = helper(i + 1, j, pairs);

        int take = 0;
        if(j == -1 || pairs[i][0] > pairs[j][1]){
            take = 1 + helper(i + 1, i, pairs);
        }
        return dp[i][j + 1] = Math.max(notake, take);
    }
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        dp = new int[n][n + 1];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        Arrays.sort(pairs, (a, b) -> { 
            return a[0] - b[0];
        });

        return helper(0, -1, pairs);
    }
}