class Solution {
    private int[] dp;
    private List<int[]> list;

    public int minDays(int n) {
        list = new ArrayList<>();
        for(int i = 1; ; i++) {
            long x = (long) i * (i + 1) / 2;
            if (x > n) break;
            list.add(new int[]{(int) x, i});
        }

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n);
    }

    private int helper(int j) {
        if(j == 0) return 0;
        if(dp[j] != -1) return dp[j];

        int res = Integer.MAX_VALUE / 2;
        for(int[] i : list) {
            int x = i[0], y = i[1];
            if(x > j) break;

            int prev = j - x;
            int skip = (prev > 0) ? 1 : 0;
            res = Math.min(res, helper(prev) + y + skip);
        }

        dp[j] = res;
        return res;
    }
}