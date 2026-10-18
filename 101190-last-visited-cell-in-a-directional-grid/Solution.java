class Solution {
    boolean isSafe(int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= visited.length || j >= visited.length || visited[i][j]){
            return false;
        }
        return true;
    }
    public int[] lastVisitedCell(char[][] grid) {

        int i = 0, j  = 0;
        int n = grid.length; 
        int m = grid[0].length; 
        int[] ans = new int[2];
        boolean[][] vis = new boolean[n][m]; 
        
        
        while(i < n && j < m && i >= 0 && j >= 0 && !vis[i][j]){
            vis[i][j] = true;
            char c = grid[i][j];
            ans = new int[]{i, j};
            if(c == 'R'){
                j++;
            }else if(c == 'L'){
                j--;
            }else if(c == 'D'){
                i++;
            }else{
                i--;
            }
        }
        return ans;
    }
}