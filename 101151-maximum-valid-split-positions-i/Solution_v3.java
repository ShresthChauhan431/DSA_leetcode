class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        int max = 0;
        for (int remove = -1; remove < n; remove++) {
            int m = n - (remove == -1 ? 0 : 1);
            if (m <= 1) {
                continue;
            }
            int[] arr = new int[m];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (i == remove) continue;
                arr[idx++] = nums[i];
            }
            int score = count(arr);
            max = Math.max(max, score);
        }
        return max;
    }

    private int count(int[] arr) {
        int m = arr.length;
        if (m <= 1) return 0;
        int[] prefix = new int[m];
        int[] suffix = new int[m];
        prefix[0] = arr[0];
        for (int i = 1; i < m; i++) {
            prefix[i] = gcd(prefix[i - 1], arr[i]);
        }
        suffix[m - 1] = arr[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], arr[i]);
        }
        int ans = 0;
        for (int i = 0; i < m - 1; i++) {
            if (prefix[i] == suffix[i + 1]) {
                ans++;
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}