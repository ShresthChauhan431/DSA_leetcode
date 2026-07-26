class Solution {
    public int largestInteger(int n, int s) {
        if (s > 9 * n) return -1;
        if (s == 0) return 0;

        StringBuilder sb = new StringBuilder();
        int remaining = s;

        for (int i = 0; i < n; i++) {
            int digit = Math.min(9, remaining);
            sb.append(digit);
            remaining -= digit;
        }

        return Integer.parseInt(sb.toString());
    }
}