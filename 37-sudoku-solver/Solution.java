class Solution {
    public boolean isSafe(int row, int col, char[][] board, char k) {
        for(int i = 0; i < 9; i++) {
            if(i == row) continue;
            if(board[i][col] == k) return false;
        }

        for(int i = 0; i < 9; i++) {
            if(i == col) continue;
            if(board[row][i] == k) return false;
        }

        int l = (row / 3) * 3;
        int r = (col / 3) * 3;
        for(int i = l; i < l + 3; i++){
            for(int j = r; j < r + 3; j++){
                if(row == i && col == j) continue;
                if(board[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }
    boolean sol = false;
    public void helper(char[][] board) {
        if(sol) return;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isSafe(i, j, board, c)){
                            board[i][j] = c;
                            helper(board);
                            if(sol) return;
                            board[i][j] = '.';
                        }
                    }
                    return;
                }
            }
        }
        sol = true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}