class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int sum = prefix[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (nums[i] * i - prefix[i]) + (sum - prefix[i + 1]) - nums[i] * (n - i - 1);
        }
        return arr;
    }
}