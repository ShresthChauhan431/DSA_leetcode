class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n / 2] == k)
            return 0;
        long cnt = 0;
        int m = n / 2;

        cnt += Math.abs(nums[m] - k);
        while (m + 1 < nums.length && nums[m + 1] < k) {
            cnt += Math.abs(nums[m + 1] - k);
            m++;
        }
        m = n / 2;
        while (m - 1 >= 0 && nums[m - 1] > k) {
            cnt += Math.abs(nums[m - 1] - k);
            m--;
        }
        return cnt;
    }
}