class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int[][] dist = new int[26][26];

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                int d = Math.abs(i - j);
                dist[i][j] = Math.min(d, 26 - d);
            }
        }

        int[] vals = new int[n];

        for(int i = 0; i < n; i++)
            vals[i] = s.charAt(i) - 'a';

        int m = n / 2;
        int ans = 0;

        for(int i = 0; i < m; i++)
            ans += dist[vals[i]][vals[n - 1 - i]];

        int[] palin = new int[2 * n];

        for(int i = 0; i < 2 * n; i++)
            palin[i] = vals[i % n];

        int maxR = n % 2 == 1 ? n : n / 2;

        for(int r = 1; r < maxR && r < ans; r++){
            int cur = r;
            for(int i = 0; i < m; i++) {
                cur += dist[palin[r + i]][palin[r + n - 1 - i]];
                if(cur >= ans)
                    break;
            }
            ans = Math.min(ans, cur);
        }

        return ans;
    }
}