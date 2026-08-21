class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = get(n);
        while (fast != 1 && slow != fast) {
            slow = get(slow);
            fast = get(get(fast));
        }
        return fast == 1;
    }

    int get(int n) {
        int total = 0;
        while (n > 0) {
            int rem = n % 10;
            total += rem * rem;
            n /= 10;
        }
        return total;
    }
}