class Solution {
    private String s, t;
    private int[][] dp;
    private int helper(int i, int j){
        if (j == t.length()) 
            return 1;

        if (i == s.length()) 
            return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int take = 0, skip = 0;

        if (s.charAt(i) == t.charAt(j))
            take = helper(i + 1, j + 1);
        
        skip = helper(i + 1, j);

        return dp[i][j] = take + skip;
    }
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        dp = new int[s.length()][t.length()];
        for (int[] d: dp)
            Arrays.fill(d, -1);
        return helper(0, 0);       
    }
}