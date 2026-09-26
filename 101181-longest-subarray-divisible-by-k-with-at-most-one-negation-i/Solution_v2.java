class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int max = 0;
        boolean[] hi = new boolean[k];
        for(int l = 0; l < n; l++){
            Arrays.fill(hi, false);
            for(int r = l; r < n; r++){
                int y = ((prefix[r + 1] - prefix[l]) % k + k) % k;
                int x = ((2 * nums[r]) % k + k) % k;
                hi[x] = true;
                if(y == 0 || hi[y]){
                    max = Math.max(max, r - l + 1);
                }
            }
        }
        return max;
    }
}