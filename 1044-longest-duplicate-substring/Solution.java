class Solution {
    private static final long P1 = 31;
    private static final long M1 = (long)1e9 + 7;
    private static final long P2 = 37;
    private static final long M2 = (long)1e9 + 7;
    
    private int solve(int len, String s){
        int n = s.length();
        if (len == 0) return 0;
        
        long p1Pow = 1;
        long p2Pow = 1;
        for (int i = 0; i < len - 1; i++) {
            p1Pow = (p1Pow * P1) % M1;
            p2Pow = (p2Pow * P2) % M2;
        }
        
        long hash1 = 0;
        long hash2 = 0;
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * P1 + s.charAt(i)) % M1;
            hash2 = (hash2 * P2 + s.charAt(i)) % M2;
        }
        
        Map<Long, Set<Long>> seen = new HashMap<>();
        seen.computeIfAbsent(hash1, k -> new HashSet<>()).add(hash2);
        
        for (int i = 1; i <= n - len; i++) {
            hash1 = (hash1 - (s.charAt(i - 1) * p1Pow) % M1 + M1) % M1;
            hash2 = (hash2 - (s.charAt(i - 1) * p2Pow) % M2 + M2) % M2;
            hash1 = (hash1 * P1 + s.charAt(i + len - 1)) % M1;
            hash2 = (hash2 * P2 + s.charAt(i + len - 1)) % M2;
            
            if (seen.containsKey(hash1) && seen.get(hash1).contains(hash2)) {
                return i;
            }
            seen.computeIfAbsent(hash1, k -> new HashSet<>()).add(hash2);
        }
        
        return -1;
    }
    
    public String longestDupSubstring(String s) {
        int n = s.length();
        int l = 1, h = n - 1;
        int ans = 0;
        int ind = -1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            int curr = solve(mid, s);
            if(curr == -1){
                h = mid - 1;
            } else{
                ans = mid; 
                ind = curr;
                l = mid + 1;
            }
        }
        return ind == -1 ? "" : s.substring(ind, ind + ans);
    }
}