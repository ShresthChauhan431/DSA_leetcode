class Solution {

    private static final long Mod1 = 1_000_000_007L;
    private static final long k1 = 27;

    public int isFound(int l, String s) {

        int n = s.length();
        if (l == 0) return -1;

        long hash = 0;
        long p = l - 1;

        for(int i = 0; i < l; i++) {
            hash += ((long)Math.pow(k1, p - i) * (s.charAt(i) - 'a' + 1)) % Mod1;
        }
        
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(hash, 0);

        p = (long)Math.pow(k1, l - 1);
        for(int i = 1; i <= n - l; i++){

            int rem = s.charAt(i - 1) - 'a' + 1;
            int add = s.charAt(i + l - 1) - 'a' + 1;

            hash = (hash - (rem * p) % Mod1) % Mod1;

            hash = (hash * k1 + add) % Mod1;

            if(map.containsKey(hash)){
                return i;
            }
            map.put(hash, i);
        }
        return -1;
    }

    public String longestDupSubstring(String s){
        int l = 1;
        int h = s.length() - 1;
        int ans = 0;
        int ind = -1;

        while (l <= h) {
            int mid = l + (h - l + 1) / 2;
            int hi = isFound(mid, s);
            if (hi == -1) {
                h = mid - 1;
            } else {
                ans = mid;
                ind = hi;
                l = mid + 1;
            }
        }

        return ind == -1 ? "" : s.substring(ind, ind + ans);
    }
}