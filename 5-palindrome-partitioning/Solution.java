class Solution {
    boolean[][] dp;
    List<List<String>> list;
    void helper(String s, int i, List<String> curr){
        if(i == s.length()){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(dp[i][j]){
                curr.add(s.substring(i, j + 1));
                helper(s, j + 1, curr);
                curr.removeLast();
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 0; j + i <= n; j++){
                int k = j + i - 1;
                if(s.charAt(j) == s.charAt(k)){
                    if(i == 2 || dp[j + 1][k - 1]){
                        dp[j][k] = true;
                    }
                }
            }
        }
        helper(s, 0, new ArrayList<>());
        return list;
    }
}