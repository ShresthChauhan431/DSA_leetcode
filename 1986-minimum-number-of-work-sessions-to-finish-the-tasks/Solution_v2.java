class Solution {
    int stime;
    int[][] dp;
    private int helper(int bits, int time, int[] task){
        int n = task.length;
        if(bits == ((1 << n) - 1)) return 1;
        if(dp[bits][time] != -1) return dp[bits][time];
        int ans = n;
        for(int i = 0; i < n; i++){
            if((bits & (1 << i)) != 0) continue;
            int nbits = bits | (1 << i);
            if(time >= task[i]){
                ans = Math.min(ans, helper(nbits, time - task[i], task));
            } else{
                ans = Math.min(ans, 1 + helper(nbits, stime - task[i], task));
            }
        }
        return dp[bits][time] = ans;
    }
    public int minSessions(int[] tasks, int sessionTime) {
        this.stime = sessionTime;
        dp = new int[(int)Math.pow(2, tasks.length) + 1][stime + 1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(0, stime, tasks);

    }
}