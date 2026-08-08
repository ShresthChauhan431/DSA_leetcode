class Solution {
    public int totalNQueens(int n) {
        boolean[][] mat = new boolean[n][n];
        return helper(0, mat);
    }

    private int helper(int row, boolean[][] mat) {
        if(row == mat.length){
            return 1;
        }
        int count = 0;
        for(int col = 0; col < mat.length; col++) {
            if(isSafe(row, col, mat)) {
                mat[row][col] = true;
                count += helper(row + 1, mat);
                mat[row][col] = false;
            }
        }
        return count;
    }
    private boolean isSafe(int row, int col, boolean[][] mat) {
        for(int i = 0; i < row; i++) 
            if(mat[i][col]) return false;
        
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--)
            if(mat[i][j]) return false;
        

        for(int i = row - 1, j = col + 1; i >= 0 && j < mat.length; i--, j++)
            if(mat[i][j]) return false;

        return true;
    }
}