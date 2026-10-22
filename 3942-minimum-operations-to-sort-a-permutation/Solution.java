class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }
        int ans = Integer.MAX_VALUE;
        boolean inc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] + 1) % n) {
                inc = false;
                break;
            }
        }

        if(inc) {
            ans = Math.min(zeroIdx, n - zeroIdx + 2);
        }

        boolean dec = true;
        for (int i = 0; i < n; i++){
            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) {
                dec = false;
                break;
            }
        }
        if (dec) {
            int idx = n - 1 - zeroIdx;
            ans =Math.min(1 + idx, 1 + (n - idx));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}