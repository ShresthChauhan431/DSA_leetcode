class Solution {
    Boolean[][] dp;
    private boolean solve(String s, int i, int open) {
        if(open < 0) return false;

        if(i == s.length())
            return open == 0;
        
        if(dp[i][open] != null)
            return dp[i][open];
        
        char ch = s.charAt(i);
        boolean ans;

        if(ch == '(')
            ans = solve(s, i + 1, open + 1);

        else if(ch == ')')
            ans = solve(s, i + 1, open - 1);
        
        else{
            ans = solve(s, i + 1, open + 1) ||
                  solve(s, i + 1, open - 1) ||
                  solve(s, i + 1, open);
        }
        
        return dp[i][open] = ans;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n + 1];
        return solve(s, 0, 0);
    }

}