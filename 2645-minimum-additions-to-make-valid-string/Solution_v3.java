class Solution {
    public int addMinimum(String word) {
        int j = 0;
        int n = word.length();
        int count = 0;
        while(true){
            int i = 0;
            while(i < 3){
                char req = (char) ('a' + i); 
                if(j < n && word.charAt(j) == req){
                    j++;
                }
                count++;
                i++;
            }
            if(j == n) break;
        }
        return count - n;
    }
}