class Solution {
    int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public void helper(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        for (int k = 0; k < 4; k++) {
            helper(i + dir[k][0], j + dir[k][1], grid);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }
}