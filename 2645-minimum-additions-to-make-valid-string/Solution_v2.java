class Solution {
    public int addMinimum(String word) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int n = word.length();
        while(true){
            int i = 0;
            while(i < 3){
                char req = (char) ('a' + i); 
                if(j < n && word.charAt(j) == req){
                    j++;
                }
                sb.append(req);
                i++;
            }
            if(j == n) break;
        }
        return sb.length() - n;
    }
}