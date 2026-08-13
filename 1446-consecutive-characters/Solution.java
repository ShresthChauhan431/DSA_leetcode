class Solution {
    public int maxPower(String s) {
        int i = 0, j = 0; 
        int max = 0; 
        while(j < s.length()){
            if(s.charAt(i) != s.charAt(j)){
                i = j;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}