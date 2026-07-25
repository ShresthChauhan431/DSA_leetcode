class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int sec = -1;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                if((c - '0') > first){
                    sec = first;
                    first = (c - '0');
                }
                if((c - '0') < first && (c - '0') > sec){
                    sec = (c - '0');
                }
            }
        }
        return sec;
    }
}