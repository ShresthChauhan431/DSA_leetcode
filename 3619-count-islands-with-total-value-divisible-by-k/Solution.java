class Solution {
    private int helper(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= 0){
            return 0;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        return val + helper(i + 1, j, grid) + helper(i - 1, j, grid) + helper(i, j + 1, grid) + helper(i, j - 1, grid);
    }
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0 && helper(i, j, grid) % k == 0) count++;
            }
        }
        return count;
    }
}