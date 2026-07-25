class Solution {
    private String[] words;
    int[] dp;
    private boolean isPredecessor(String s, String t){
        if (s.length() + 1 != t.length()) return false;
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return i == s.length();
    }

    private int helper(int i){
        if (i == words.length)
            return 0;

        if(dp[i] != -1)
            return -1;

        int ans = 1;
        for (int j = i + 1; j < words.length; j++){
            if (isPredecessor(words[i], words[j])){
                ans = Math.max(ans, 1 + helper(j));
            }
        }
        return dp[i] = ans;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        this.words = words;
        int ans = 0;
        dp = new int[words.length];

        for (int i = 0; i < words.length; i++){
            Arrays.fill(dp, -1);
            ans = Math.max(ans, helper(i));
        }

        return ans;
    }

}