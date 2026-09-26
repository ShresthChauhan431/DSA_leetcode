class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] arr = new int[m][n];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int val = grid.get(i).get(j);
                int prev = Integer.MAX_VALUE;
                if (i > 0) prev = Math.min(prev, arr[i - 1][j]);
                if (j > 0) prev = Math.min(prev, arr[i][j - 1]);
                if(prev != Integer.MAX_VALUE) {
                    max = Math.max(max, val - prev);
                }
                arr[i][j] = Math.min(val, prev);
            }
        }
        return max;
    }
}