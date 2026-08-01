class Solution {
    public int countValidPrefixes(String s) {
        int count = 0; 
        int zero = 0;
        int one = 0;
        for(char c: s.toCharArray()){
            if(c == '0')
                zero++;
            else one++;
            if(Math.abs(zero - one) <= 1) {
                count++;
            }
        }
        return count;
    }
}