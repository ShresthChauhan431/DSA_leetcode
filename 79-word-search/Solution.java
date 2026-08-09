class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean helper(int i, int j, char[][] board, String s, int idx){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*'){
            return false;
        }
        
        if(idx == s.length()) return true;
        if(board[i][j] != s.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        for(int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if(helper(ni, nj, board, s, idx + 1)){
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        // dir = {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && helper(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}