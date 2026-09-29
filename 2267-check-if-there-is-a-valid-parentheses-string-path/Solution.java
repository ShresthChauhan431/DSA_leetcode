class Solution {
    int[][][] dp;
    public boolean helper(int i, int j, char[][] grid, int open, int close){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        if(open < close) return false;
        
        if(grid[i][j] == '('){
            open++;
        }else {
            close++;
        }
        int hi = open - close;
        
        if(hi < 0 || hi >= dp[0][0].length) return false;
        
        if(dp[i][j][hi] != -1) return dp[i][j][hi] == 1;
        
        if(i == grid.length - 1 && j == grid[0].length - 1){
            dp[i][j][hi] = (hi == 0) ? 1 : 0;
            return hi == 0;
        }
        
        boolean ans = false;
        ans |= helper(i + 1, j, grid, open, close);
        ans |= helper(i, j + 1, grid, open, close);
        
        dp[i][j][hi] = ans ? 1 : 0;
        return ans;
    }
    
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')' || grid[grid.length - 1][grid[0].length - 1] == '(') return false;
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][m + n];
        for(int[][] i: dp){
            for(int[] j: i){
                Arrays.fill(j, -1);
            }
        }
        return helper(0, 0, grid, 0, 0);
    }
}