class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int cnt = 0;
        for(char c: s.toCharArray()){
            if(c == '(') cnt++;
            else if(c == ')')cnt--;
            max = Math.max(max, cnt);
        }
        return max;
    }
}