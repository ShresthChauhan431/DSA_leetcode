class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            int r = rowShift[i];
            if (r == 0)
                continue;
            int[] nr = new int[n];
            for (int j = 0; j < n; j++) {
                int nc = (j - r + n) % n;
                nr[nc] = ans[i][j];
            }
            ans[i] = nr;
        }

        for (int i = 0; i < n; i++) {
            int c = colShift[i];
            if (c == 0)
                continue;
            int[] cc = new int[n];
            for (int j = 0; j < n; j++) {
                cc[j] = ans[j][i];
            }

            int[] nc = new int[n];
            for (int j = 0; j < n; j++) {
                int nr = (j - c + n) % n;
                nc[nr] = cc[j];
            }
            for (int j = 0; j < n; j++) {
                ans[j][i] = nc[j];
            }
        }
        return ans;
    }
}