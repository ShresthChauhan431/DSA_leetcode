class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        int st = 0; 
        int max = 1; 
        for(int i = 2; i <= n; i++){
            for(int j = 0; j + i <= n; j++){
                int k = j + i - 1;
                if(s.charAt(j) == s.charAt(k)){
                    if(i == 2 || dp[j + 1][k - 1]){
                        dp[j][k] = true;
                        if(i > max){
                            max = i;
                            st = j;
                        }
                    }
                }
            }
        }
        return s.substring(st, max + st);
    }
}