class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < n; j++){
                int y = (prefix[j + 1] - prefix[i]) % k;
                int x = (2 * nums[j]) % k;
                set.add(x);
                if(y == 0 || set.contains(y)){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}