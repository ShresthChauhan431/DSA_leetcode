class Solution {
    public long maxValue(int[] nums) {
        int n = nums.length;
        long b = 0;
        long[] max = {0, Long.MIN_VALUE};
        long ans = 0;
        long sum = 0;

        for(int i = 0; i < n; i++){
            long x = (i % 2 == 0) ? 1 : -1;
            b += x * nums[i];
            sum += x * nums[i];

            int p = (i + 1) & 1;
            if(max[p] != Long.MIN_VALUE){
                ans = Math.max(ans, max[p] - sum);
            }
            max[p] = Math.max(max[p], sum);
        }

        return b + 2L * ans;
    }
}