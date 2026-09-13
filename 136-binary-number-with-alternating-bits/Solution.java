class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n == 0) return true;
        boolean flag = (n & 1) == 1;
        n = n >> 1;

        while (n > 0) {
            boolean curr = (n & 1) == 1;
            if (curr == flag) {
                return false;
            }
            flag = curr;
            n = n >> 1;
        }
        return true;
    }
}