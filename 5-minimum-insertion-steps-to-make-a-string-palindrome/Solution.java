class Solution {
    private int[][] dp;
    private int helper(String s, int i, int j){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = helper(s, i + 1, j - 1);
        }
        return dp[i][j] = 1 + Math.min(helper(s, i + 1, j), helper(s, i, j - 1));
    }
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(s, 0, s.length() - 1);
    }
}