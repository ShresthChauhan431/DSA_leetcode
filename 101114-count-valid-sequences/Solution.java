class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int countValidSequences(int n, int k) {
        if(n < k) return 0;
        long  total = comb(n - 1, k -1);
        if((n - k) % 2 != 0) return (int) total;

        int m = (n - k) / 2;

        long allOdd = comb(m + k - 1, k - 1);
        long ans = (total - allOdd + MOD) % MOD;
        return (int)ans;
    }
    private long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;
        
        long num = 1, den = 1;
        for (int i = 0; i < r; i++) {
            num = num * (n - i) % MOD;
            den = den * (i + 1) % MOD;
        }
        
        return num * modInverse(den) % MOD;
    }
    
    private long modInverse(long a) {
        return power(a, MOD - 2);
    }
    
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}