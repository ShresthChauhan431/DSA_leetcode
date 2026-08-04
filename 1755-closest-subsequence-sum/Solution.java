class Solution {
    int[] nums;

    void helper(int i, int end, ArrayList<Long> list, Long sum) {
        if (i == end) {
            list.add(sum);
            return;
        }

        helper(i + 1, end, list, sum + nums[i]);
        helper(i + 1, end, list, sum);
    }

    public int minAbsDifference(int[] nums, int goal) {
        this.nums = nums;
        long ans = Long.MAX_VALUE;

        int mid = nums.length / 2;
        ArrayList<Long> first = new ArrayList<>();
        ArrayList<Long> last = new ArrayList<>();

        helper(0, mid + 1, first, 0L);
        helper(mid + 1, nums.length, last, 0L);

        first.sort(null);
        last.sort(null);

        for (int i = 0; i < first.size(); i++) {
            long target = goal - first.get(i);

            int idx = binarySearch(last, target);

            if (idx < last.size()) {
                ans = Math.min(ans,
                        Math.abs(first.get(i) + last.get(idx) - goal));
            }

            if (idx > 0) {
                ans = Math.min(ans,
                        Math.abs(first.get(i) + last.get(idx - 1) - goal));
            }
        }

        return (int) ans;
    }

    public static int binarySearch(List<Long> arr, long target) {
        int low = 0, high = arr.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}