import java.util.*;

class Solution {

    void helper(int i, int end, int len, long sum, int[] nums,
                Map<Integer, Set<Long>> map) {

        if (i == end) {
            map.computeIfAbsent(len, k -> new HashSet<>());
            map.get(len).add(sum);
            return;
        }

        helper(i + 1, end, len + 1, sum + nums[i], nums, map);
        helper(i + 1, end, len, sum, nums, map);
    }

    public int minimumDifference(int[] nums) {

        Map<Integer, Set<Long>> map1 = new HashMap<>();
        Map<Integer, Set<Long>> map2 = new HashMap<>();

        int n = nums.length;
        int mid = n / 2;

        long total = 0;
        for (int x : nums)
            total += x;

        helper(0, mid, 0, 0L, nums, map1);
        helper(mid, n, 0, 0L, nums, map2);

        // Convert map2 into sorted lists once
        Map<Integer, List<Long>> right = new HashMap<>();

        for (Map.Entry<Integer, Set<Long>> e : map2.entrySet()) {
            List<Long> list = new ArrayList<>(e.getValue());
            Collections.sort(list);
            right.put(e.getKey(), list);
        }

        long ans = Long.MAX_VALUE;

        for (Map.Entry<Integer, Set<Long>> entry : map1.entrySet()) {

            int leftLen = entry.getKey();
            int needLen = mid - leftLen;

            List<Long> list2 = right.get(needLen);

            for (long a : entry.getValue()) {

                double target = total / 2.0 - a;

                int idx = lowerBound(target, list2);

                if (idx < list2.size()) {
                    long chosen = a + list2.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * chosen));
                }

                if (idx > 0) {
                    long chosen = a + list2.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * chosen));
                }
            }
        }

        return (int) ans;
    }

    private int lowerBound(double target, List<Long> list) {

        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}