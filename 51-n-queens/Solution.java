class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        boolean[][] mat = new boolean[n][n];

        helper(0, mat);

        return res;
    }

    public void helper(int row, boolean[][] mat) {
        // System.out.println("hello");
        if(row == mat.length){
            List<String> list = new ArrayList<>(); 

            for(int i = 0; i < mat.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < mat.length; j++){ 
                    if(mat[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            // System.out.println("hello");

            res.add(new ArrayList<>(list));
            return;
        }    
        for(int col = 0; col < mat.length; col++) {
            if(isSafe(row, col, mat)){
                mat[row][col] = true;
                helper(row + 1, mat);
                mat[row][col] = false;
            }
        }
    }

    public boolean isSafe(int row, int col, boolean[][] mat) {
        for(int i = 0; i < row; i++)
            if(mat[i][col])
                return false;
     
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--) 
                if(mat[i][j])
                    return false;
           
        for(int i = row - 1, j = col + 1; i >= 0 && j < mat.length; i--,j++) 
                if(mat[i][j])
                    return false;
        
        // System.out.println("hi");
        return true;
    }
}