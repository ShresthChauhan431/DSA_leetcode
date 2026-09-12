class Solution {
    private List<int[]> list;
    private int[] dp;
    private int helper(int i){
        if(i == 0) return 0;
        int res = 10000000;
        if(dp[i] != -1) return dp[i];

        for(int[] j: list){
            if(j[1] > i) break;
            int prev = i - j[1];
            int skip = 0;
            if(prev > 0)
                skip = 1;
            res = Math.min(res, j[0] + helper(prev) + skip);
        }
        dp[i] = res;
        return res;
    }
    
    public int minDays(int n) {
        list = new ArrayList<>(); 
        list.add(new int[]{1,1});

        for(int i = 2; ; i++)
            if(list.getLast()[1] + i <= n)
                list.add(new int[]{i, list.getLast()[1] + i});
            else
                break;
        

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n);
    }

}