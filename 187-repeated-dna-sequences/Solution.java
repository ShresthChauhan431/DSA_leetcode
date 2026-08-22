class Solution {
    public class DoubleRollingHash {
        private static final long P1 = 31;
        private static final long M1 = 1_000_000_007;

        private static final long P2 = 37;
        private static final long M2 = 1_000_000_009;

        private long hash1 = 0;
        private long hash2 = 0;

        private long p1Pow = 1;
        private long p2Pow = 1;
        private int windowSize = 0;

        public DoubleRollingHash(String initialWindow) {
            this.windowSize = initialWindow.length();
            if (windowSize == 0)
                return;

            for (int i = 0; i < windowSize; i++) {
                char c = initialWindow.charAt(i);

                hash1 = (hash1 * P1 + c) % M1;
                hash2 = (hash2 * P2 + c) % M2;

                if (i < windowSize - 1) {
                    p1Pow = (p1Pow * P1) % M1;
                    p2Pow = (p2Pow * P2) % M2;
                }
            }
        }

        public void roll(char oldChar, char newChar) {
            hash1 = (hash1 - (oldChar * p1Pow) % M1 + M1) % M1;
            hash2 = (hash2 - (oldChar * p2Pow) % M2 + M2) % M2;
            hash1 = (hash1 * P1 + newChar) % M1;
            hash2 = (hash2 * P2 + newChar) % M2;
        }

        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof DoubleRollingHash))
                return false;
            DoubleRollingHash other = (DoubleRollingHash) o;
            return this.hash1 == other.hash1 && this.hash2 == other.hash2;
        }
        public int hashCode() {
            return Objects.hash(hash1, hash2);
        }
        public String toString() {
            return String.format("(%d, %d)", hash1, hash2);
        }
    }
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) return new ArrayList<>();
        
        Map<DoubleRollingHash, String> seen = new HashMap<>();
        Set<String> res = new HashSet<>(); 
        
        String st = s.substring(0, 10);
        DoubleRollingHash db = new DoubleRollingHash(st);
        seen.put(db, st);
        
        for(int i = 1; i <= s.length() - 10; i++){
            db.roll(s.charAt(i - 1), s.charAt(i + 9));
            String curr = s.substring(i, i + 10);
            
            if(seen.containsKey(db)){
                if(seen.get(db).equals(curr)){
                    res.add(curr);
                }
            } else {
                seen.put(db, curr);
            }
        }
        
        return new ArrayList<>(res);

    }
}