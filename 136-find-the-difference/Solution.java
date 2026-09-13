class Solution {
    public char findTheDifference(String s, String t) {
        int miss = 0;
        for(char c : t.toCharArray()){
            miss ^= (c - 'a');
        }
        for(char c: s.toCharArray()){
            miss ^= (c - 'a');
        }
        return (char)(miss + 'a');
    }
}