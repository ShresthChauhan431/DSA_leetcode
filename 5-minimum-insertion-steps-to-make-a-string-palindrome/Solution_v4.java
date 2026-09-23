class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int min = Integer.MAX_VALUE;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j + i <= n; j++){
                int k = j + i - 1;
                if(s.charAt(j) == s.charAt(k)){
                        dp[j][k] = dp[j + 1][k - 1];
                }else{
                    dp[j][k] = 1 + Math.min(dp[j + 1][k], dp[j][k - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}