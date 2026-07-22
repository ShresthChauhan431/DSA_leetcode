class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(text1.length() - 1, text2.length() - 1, text1, text2);
    }
    public int helper(int i, int j, String s, String t){

        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return 1 + helper(i - 1, j - 1, s, t);
        }
        return dp[i][j] = Math.max(helper(i - 1, j, s, t), helper(i, j - 1, s, t));
    }
}