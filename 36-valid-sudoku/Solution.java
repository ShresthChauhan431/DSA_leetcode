class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != '.'){
                    if(!isSafe(i, j, board, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
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
}