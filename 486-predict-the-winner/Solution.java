class Solution {
    private boolean helper(int i, int j, int[] nums, long p1, long p2) {
        if (i > j) {
            return p1 >= p2;
        }

        if ((nums.length - (j - i + 1)) % 2 == 0) {
            return helper(i + 1, j, nums, p1 + nums[i], p2)
                    || helper(i, j - 1, nums, p1 + nums[j], p2);
        } else {
            return helper(i + 1, j, nums, p1, p2 + nums[i])
                    && helper(i, j - 1, nums, p1, p2 + nums[j]);
        }
    }

    public boolean predictTheWinner(int[] nums) {
        return helper(0, nums.length - 1, nums, 0L, 0L);
    }
}