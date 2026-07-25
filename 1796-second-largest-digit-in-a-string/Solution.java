class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int sec = -1;
        for(char c: s.toCharArray()){
            if((c - '0') >= 0 && (c - '0') <= 9){
                if((c - '0') > first){
                    sec = first;
                    first = (c - '0');
                }
            }
        }
        return sec;
    }
}