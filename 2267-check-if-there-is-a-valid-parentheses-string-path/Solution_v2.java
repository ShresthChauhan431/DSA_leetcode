class Solution {
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')' || grid[grid.length - 1][grid[0].length - 1] == '(') return false;
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][][] dp = new boolean[m][n][m + n];
        dp[0][0][1] = true;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m + n; k++){
                    if(!dp[i][j][k]) continue;
                    
                    if(j < n - 1){
                        int count;
                        if(grid[i][j + 1] == '(') {
                            count = k + 1;
                        } else {
                            count = k - 1;
                        }
                        if(count >= 0 && count < m + n) {
                            dp[i][j + 1][count] = true;
                        }
                    }
                    
                    if(i < m - 1){
                        int count;
                        if(grid[i + 1][j] == '(') {
                            count = k + 1;
                        } else {
                            count = k - 1;
                        }
                        if(count >= 0 && count < m + n) {
                            dp[i + 1][j][count] = true;
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}