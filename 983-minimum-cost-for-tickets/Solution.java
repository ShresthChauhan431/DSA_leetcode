class Solution {
    int[] days;
    int[] costs;
    int[] dp;

    private int find(int i, int tar) {
        for (int j = i; j < days.length; j++) {
            if (days[j] > tar)
                return j;
        }
        return days.length;
    }

    private int helper(int i) {
        if (i >= days.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];
        int one = costs[0] + helper(i + 1);
        int ind = find(i, days[i] + 6);
        int seven = costs[1] + helper(ind);
        ind = find(i, days[i] + 29);
        int thrty = costs[2] + helper(ind);

        return dp[i] = Math.min(one, Math.min(seven, thrty));

    }

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(0);
    }
}